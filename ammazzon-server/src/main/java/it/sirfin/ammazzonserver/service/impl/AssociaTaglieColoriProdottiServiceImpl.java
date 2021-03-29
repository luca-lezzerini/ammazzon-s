package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaColoreTagliaDto;
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
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public ListaProdottiDto cercaProdotti(String criterioRic) {
        ListaProdottiDto dtoRes = new ListaProdottiDto();
        List<Prodotto> prodotti = prodottoRepository.trovaPerCodiceODescrizioneLike(criterioRic);
        prodotti.forEach(p -> {
            p.setProdottiColori(new ArrayList<>());
        });
        dtoRes.setListaProdotti(prodotti);
        return dtoRes;
    }

    @Override
    public ListaProdottoColoriDto coloriAssociatiProdotto(Long id) {
        ListaProdottoColoriDto dtoRes = new ListaProdottoColoriDto();
        List<ProdottoColore> lista = prodottoColoreRepository.coloriAssociatiProdotto(id);
        dtoRes.setListaProdottoColori(lista);
        lista.forEach(l -> {
            System.out.println(l);
        });
        return dtoRes;
    }

    @Override
    public ListaColoreTagliaDto coloriTaglieAssociateProdottoColore(Long id) {
        System.out.println("siamo in  coloriTaglieAssociateProdottoColore");
        ListaColoreTagliaDto dtoRes = new ListaColoreTagliaDto();
        List<ColoreTaglia> coloriTaglieAssociate = coloreTagliaRepository.taglieProdottoColore(id);
        List<VarianteTaglia> taglieNonAssociate = taglieNonAssociate(coloriTaglieAssociate);
        //rimuovo colori taglie nel risultato per il client per velocizzare l'
        //operazione
        taglieNonAssociate.forEach(tna -> {
            tna.setColoriTaglie(new ArrayList<>());
        });
        dtoRes.setColoriTaglie(coloriTaglieAssociate);
        dtoRes.setNotColoriTaglie(taglieNonAssociate);
        dtoRes.getNotColoriTaglie().forEach(n -> {
            System.out.println(n);
        });
        return dtoRes;
    }

    @Override
    public ListaColoreTagliaDto disassociaTaglia(Long idColoreTaglia, Long idProdottoColore) {
        System.out.println("\n\n\n idColoreTaglia: " + idColoreTaglia + "idProdottoColore: " + idProdottoColore);
        coloreTagliaRepository.deleteById(idColoreTaglia);
        return coloriTaglieAssociateProdottoColore(idProdottoColore);
    }

    @Override
    public ListaColoreTagliaDto associaTaglia(ProdottoColore pc, VarianteTaglia vt) {
        associaProdottoColoreTaglia(pc, vt);
        return new ListaColoreTagliaDto();
    }

    /**
     * Ottiene tutte le taglie non associate date, date tutte le taglie
     * associate
     *
     * @param coloriTaglieAssociate
     * @return
     */
    private List<VarianteTaglia> taglieNonAssociate(List<ColoreTaglia> coloriTaglieAssociate) {
        Instant i = Instant.now();
        System.out.println("");
        System.out.println("\n*************************************************");
        System.out.println("SIAMO IN TaglieNonAssociate()");
        List<VarianteTaglia> tutteLeTaglie = varianteTagliaRepository.findAll();
        System.out.println("Taglie trovate: " + tutteLeTaglie.size());
        coloriTaglieAssociate.forEach(cta -> {
            tutteLeTaglie.remove(cta.getVarianteTaglia());
        });
        System.out.println("numero taglie dopo rimozione: " + tutteLeTaglie.size());
        //ritorno tutte le taglie dopo aver rimosso quelle associate
        Instant i2 = Instant.now();
        System.out.println("durata operazine taglie non associate: " + Duration.between(i, i2).toMillis());
        System.out.println("\n*************************************************");
        return tutteLeTaglie;
    }

    private ColoreTaglia associaProdottoColoreTaglia(ProdottoColore pc, VarianteTaglia vt) {
        //recupero pc, vt
        System.out.println("siamo in associaProdottoColoreTaglia");
        pc = prodottoColoreRepository.findById(pc.getId()).get();
        vt = varianteTagliaRepository.findById(vt.getId()).get();
        
        ColoreTaglia ct = new ColoreTaglia();
        ct = coloreTagliaRepository.save(ct);
        ct.setProdottoColore(pc);
        ct.setVarianteTaglia(vt);
        ct = coloreTagliaRepository.save(ct);
        pc.getColoriTaglie().add(ct);
        vt.getColoriTaglie().add(ct);
        System.out.println("Sto per salvare pc : " + pc);
        varianteTagliaRepository.save(vt);
        prodottoColoreRepository.save(pc);
        return ct;
    }

}
