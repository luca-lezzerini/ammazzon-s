package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaColoreTagliaDto;
import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.model.ColoreTaglia;
import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import it.sirfin.ammazzonserver.repository.ColoreTagliaRepository;
import it.sirfin.ammazzonserver.repository.ProdottoColoreRepository;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.repository.VarianteColoreRepository;
import it.sirfin.ammazzonserver.repository.VarianteTagliaRepository;
import it.sirfin.ammazzonserver.service.AssociaTaglieColoriProdottiService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AssociaTaglieColoriProdottiServiceImpl implements AssociaTaglieColoriProdottiService {

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    VarianteColoreRepository varianteColoreRepository;

    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;

    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;

    @Autowired
    ColoreTagliaRepository coloreTagliaRepository;

    static final Logger logger = LoggerFactory.getLogger(AssociaTaglieColoriProdottiServiceImpl.class);

    /**
     * Ricerca prodotto per criterio di ricerca (Codice o DescrizioneLike)
     *
     * @param criterioRic
     * @return ListaProdottiDto
     */
    @Override
    public ListaPagineDto<Prodotto> cercaProdotti(String criterioRic, int numeroPagina) {
        logger.debug("Sto cercando per: " + criterioRic + " = Codice o DescrizioneLike");
        try {
            Page pag = prodottoRepository.trovaCodiceODescrizionePageable(
                    criterioRic,
                    PageRequest.of(numeroPagina - 1, 10));
            List<Prodotto> listaProdotti = pag.getContent();
            ListaPagineDto<Prodotto> prodottiPag = new ListaPagineDto<>(
                    pag.getContent(),
                    pag.getPageable().getPageNumber() +1,
                    pag.getTotalPages());
            return prodottiPag;
        } catch (Exception e) {
            logger.error("PAGINA RICHIESTA < 0");
            ListaPagineDto<Prodotto> prodottiPag = new ListaPagineDto<>();
            return prodottiPag;

        }
    }

    @Override
    public ListaProdottoColoriDto selezionaProdotto(Long id) {
        logger.debug("Sto cercando il prodotto: " + id);
        List<ProdottoColore> lista = prodottoColoreRepository.coloriAssociatiProdotto(id);
        logger.debug("Ho trovato " + lista.size() + " prodotti");
        ListaProdottoColoriDto dtoRes = new ListaProdottoColoriDto(lista);
        return dtoRes;
    }

    /**
     * Trova tutte le taglie associate e non a un prodottoColore, dato in input
     * l'id del prodotto colore desiderato.
     *
     * @param idProdottoColore
     * @return
     */
    @Override
    public ListaColoreTagliaDto selezionaProdottoColore(Long idProdottoColore) {
        logger.debug("Sto cercando le taglie associate a prodottoColore: " + idProdottoColore);
        List<ColoreTaglia> coloriTaglieAssociate = coloreTagliaRepository.taglieProdottoColore(idProdottoColore);
        logger.debug("Ho trovato " + coloriTaglieAssociate.size() + " taglie associate");
        logger.debug("Cerco tutte le taglie non associate ");
        List<VarianteTaglia> taglieNonAssociate = trovaTaglieNonAssociate(coloriTaglieAssociate);
        logger.debug("Ho trovato " + taglieNonAssociate.size() + " taglie non associate");
        //rimuovo colori taglie nel risultato per il client per velocizzare l'
        //operazione
        taglieNonAssociate.forEach(tna -> {
            tna.setColoriTaglie(new ArrayList<>());
        });
        ListaColoreTagliaDto dtoRes = new ListaColoreTagliaDto(
                coloriTaglieAssociate, taglieNonAssociate);
        return dtoRes;
    }

    @Override
    public ListaColoreTagliaDto disassociaTaglia(Long idColoreTaglia, Long idProdottoColore) {
        coloreTagliaRepository.deleteById(idColoreTaglia);
        return selezionaProdottoColore(idProdottoColore);
    }

    @Override
    public ListaColoreTagliaDto associaTaglia(ProdottoColore pc, VarianteTaglia vt) {
        associaProdottoColoreTaglia(pc, vt);
        return selezionaProdottoColore(pc.getId());
    }

    @Override
    public ListaColoreTagliaDto disassociaTutti(Long idProdottoColore) {
        //recupero prodotto colore
        ProdottoColore pc = prodottoColoreRepository.findById(idProdottoColore).get();
        //recupero le associazioni
        List<ColoreTaglia> coloriTaglie = pc.getColoriTaglie();
        //le cancello su db
        coloriTaglie.forEach(ct -> {
            coloreTagliaRepository.deleteById(ct.getId());
        });
        //IL METODO POTREBBE ANCHE ESSERE VOID
        return selezionaProdottoColore(idProdottoColore);
    }

    /**
     * Associa tutte le taglie presenti sul db a un ProdottoColore scelto
     *
     * @param idProdottoColore
     * @return ListaColoreTagliaDto
     */
    @Override
    public ListaColoreTagliaDto associaTutti(Long idProdottoColore) {
        //recupera tutte le taglie 
        List<VarianteTaglia> taglie = varianteTagliaRepository.findAll();
        //recupero prodotto colore (non mi fido del client)
        ProdottoColore pc = prodottoColoreRepository.findById(idProdottoColore).get();
        // associa tutte le taglie al prodottoColore
        taglie.forEach(t -> {
            associaProdottoColoreTaglia(pc, t);
        });
        return selezionaProdottoColore(idProdottoColore);
    }

    ///////////////////////////////////////////////////////////////////////
    //////////////////////////////////METODI PRIVATI///////////////////////
    ///////////////////////////////////////////////////////////////////////
    /**
     * Ottiene tutte le taglie non associate, date tutte le taglie associate in
     * input
     *
     * @param coloriTaglieAssociate
     * @return
     */
    //DA MIGLIORARE
    private List<VarianteTaglia> trovaTaglieNonAssociate(List<ColoreTaglia> coloriTaglieAssociate) {
        List<VarianteTaglia> tutteLeTaglie = varianteTagliaRepository.findAll();
        coloriTaglieAssociate.forEach(cta -> {
            tutteLeTaglie.remove(cta.getVarianteTaglia());
        });
        //ritorno tutte le taglie dopo aver rimosso quelle che erano già associate
        return tutteLeTaglie;
    }

    private ColoreTaglia associaProdottoColoreTaglia(ProdottoColore pc, VarianteTaglia vt) {
        //recupero pc, vt
        pc = prodottoColoreRepository.findById(pc.getId()).get();
        vt = varianteTagliaRepository.findById(vt.getId()).get();
        ColoreTaglia ct = new ColoreTaglia();
        ct = coloreTagliaRepository.save(ct);
        ct.setProdottoColore(pc);
        ct.setVarianteTaglia(vt);
        ct = coloreTagliaRepository.save(ct);
        pc.getColoriTaglie().add(ct);
        vt.getColoriTaglie().add(ct);
        varianteTagliaRepository.save(vt);
        prodottoColoreRepository.save(pc);
        return ct;
    }

}
