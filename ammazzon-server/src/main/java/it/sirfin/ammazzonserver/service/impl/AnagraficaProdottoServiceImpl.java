package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ProdottoDto;
import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.repository.ProdottoColoreRepository;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.service.AnagraficaProdottoService;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AnagraficaProdottoServiceImpl implements AnagraficaProdottoService {

    static final Logger logger = LoggerFactory.getLogger(AnagraficaProdottoServiceImpl.class);

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;

    
    @Override
    public ListaProdottiDto inserisci(Prodotto p) {
        prodottoRepository.save(p);
        return aggiorna();
    }
    
    /**
     * disassocia un Prodotto da ColoreProdotto
     * dopodiché elimina il Prodotto dal DB
     * 
     * @param prodotto
     * @return ListaProdottiDto
     */
    @Override
    public ListaProdottiDto elimina(Prodotto prodotto) {
        Instant i1 = Instant.now();
        int prodottiDisassociati = prodottoColoreRepository.disassociaColoreProdotto(prodotto.getId());
        Instant i2 = Instant.now();
        System.out.println("Prodotti disassociati = "+ prodottiDisassociati);
        System.out.println("Tempo query disassociaColoreProdotto(p.getId()) = " + Duration.between(i1, i2).toMillis() + "ms");
        prodottoRepository.delete(prodotto);
        return aggiorna();
    }

    @Override
    public ListaProdottiDto modifica(Prodotto p) {
        prodottoRepository.modificaProdotto(p.getCodice(), p.getDescrizione(), p.getPrezzo(), p.getId());
        return aggiorna();

    }

    @Override
    public ProdottoDto seleziona(Prodotto p) {
        return new ProdottoDto(prodottoRepository.findById(p.getId()).get());
    }

    @Override
    public ListaPagineDto<Prodotto> ricerca(String criterio, int numeroPagina, int numeroRisultati) {
        try {
            Page p = prodottoRepository.trovaCodiceODescrizionePageable(
                    criterio, PageRequest.of(numeroPagina, numeroRisultati));
            ListaPagineDto<Prodotto> dtoRes = new ListaPagineDto<>();
            dtoRes.setListaPagine(p.getContent());
            dtoRes.setPageNum(p.getPageable().getPageNumber() + 1);
            dtoRes.setTotalPages(p.getTotalPages());
            return dtoRes;
        } catch (Exception e) {
            logger.error("numero pagina richiesta < 0, o problema con numero risultati richiesti");
            throw new RuntimeException();
        }

    }

    @Override
    public ListaProdottiDto aggiorna() {
        //Il client richiede una pagina numero pagina, numero elementi per pagina
        //definire sort
        //il server spedisce al client la pagina
        //il client la visualizza

        //numero di pagine
        //a che pagina siamo
        //lista di prodotto
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page p = prodottoRepository.findAll(pageRequest);
        System.out.println("pagina p: " + p.getContent());

        List<Prodotto> prodotti = p.getContent();
        return new ListaProdottiDto(prodotti);
    }

    @Override
    public ListaPagineDto<Prodotto> ricercaProdottiPaginata(String criterioRicerca, int numeroPagina) {
        Pageable pageRequest = PageRequest.of(numeroPagina - 1, 10);
        Page p = prodottoRepository
                .findAll(pageRequest);
        System.out.println("contenuto della pagina: " + p.getContent() + "\n"
                + "totale pagine: " + p.getTotalPages() + "\n"
                + "pagina corrente: " + p.getPageable().getPageNumber());
        ListaPagineDto<Prodotto> prodottiPag = new ListaPagineDto<>(
                p.getContent(),
                p.getPageable().getPageNumber(),
                p.getTotalPages());
        return prodottiPag;
    }

}
