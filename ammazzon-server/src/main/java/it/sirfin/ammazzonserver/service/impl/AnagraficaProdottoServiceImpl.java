package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ProdottoDto;
import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.repository.ProdottoColoreRepository;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.service.AnagraficaProdottoService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AnagraficaProdottoServiceImpl implements AnagraficaProdottoService {

    @Autowired
    ProdottoRepository prodottoRepository;
    

    @Override
    public ListaProdottiDto inserisci(Prodotto p) {
        prodottoRepository.save(p);
        return aggiorna();
    }

    @Override
    public ListaProdottiDto elimina(Prodotto p) {
        
        prodottoRepository.delete(p);
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
    public ListaProdottiDto ricerca(String criterio) {
      return new ListaProdottiDto(prodottoRepository.findByCodiceContainsOrDescrizioneContainsOrPrezzoContains(criterio,criterio,Double.valueOf(criterio)));
    }

    @Override
    public ListaProdottiDto aggiorna() {
        return new ListaProdottiDto(prodottoRepository.findAll());
    }

}
