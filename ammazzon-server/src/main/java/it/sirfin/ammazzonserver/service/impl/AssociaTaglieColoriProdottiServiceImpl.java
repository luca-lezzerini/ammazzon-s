package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaColoriDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.VarianteColore;
import it.sirfin.ammazzonserver.repository.ProdottoColoreRepository;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.repository.VarianteColoreRepository;
import it.sirfin.ammazzonserver.service.AssociaTaglieColoriProdottiService;
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
    ProdottoColoreRepository prodottoColoreRepository;

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

    

}
