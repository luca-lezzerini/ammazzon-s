package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaColoreTagliaDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.model.ColoreTaglia;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import it.sirfin.ammazzonserver.repository.ColoreTagliaRepository;
import it.sirfin.ammazzonserver.repository.ProdottoColoreRepository;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.repository.VarianteColoreRepository;
import it.sirfin.ammazzonserver.repository.VarianteTagliaRepository;
import it.sirfin.ammazzonserver.service.AssociaTaglieColoriProdottiService;
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
        dtoRes.setListaProdotti(
                prodottoRepository.trovaPerCodiceODescrizioneLike(criterioRic));
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
        ListaColoreTagliaDto dtoRes = new ListaColoreTagliaDto();
        List<ColoreTaglia> coloriTaglieAssociate = coloreTagliaRepository.taglieProdottoColore(id);
        List<VarianteTaglia> taglieNonAssociate = taglieNonAssociate(coloriTaglieAssociate);
        dtoRes.setColoriTaglie(coloriTaglieAssociate);
        dtoRes.setNotColoriTaglie(taglieNonAssociate);
        dtoRes.getNotColoriTaglie().forEach(n -> {
            System.out.println(n);
        });
        return dtoRes;
    }

    /**
     * Ottiene tutte le taglie non associate date, date tutte le taglie
     * associate
     *
     * @param coloriTaglieAssociate
     * @return
     */
    private List<VarianteTaglia> taglieNonAssociate(List<ColoreTaglia> coloriTaglieAssociate) {
        System.out.println("\n*************************************************");
        System.out.println("SIAMO IN TaglieNonAssociate()");
        List<VarianteTaglia> tutteLeTaglie = varianteTagliaRepository.findAll();
        System.out.println("Taglie trovate: " + tutteLeTaglie.size());
        coloriTaglieAssociate.forEach(cta -> {
            tutteLeTaglie.remove(cta.getVarianteTaglia());
        });
        System.out.println("numero taglie dopo rimozione: " + tutteLeTaglie.size());
        System.out.println("\n*************************************************");
        //ritorno tutte le taglie dopo aver rimosso quelle associate
        return tutteLeTaglie;
    }

}
