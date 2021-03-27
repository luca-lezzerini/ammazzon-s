package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.service.AssociaTaglieColoriProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociaTaglieColoriProdottiServiceImpl implements AssociaTaglieColoriProdottiService {

    @Autowired
    ProdottoRepository prodottoRepository;

    @Override
    public ListaProdottiDto cercaProdotti(String criterioRic) {
        ListaProdottiDto dtoRes = new ListaProdottiDto();
        dtoRes.setListaProdotti(
                prodottoRepository.trovaCodiceODescrizione(criterioRic));
        return dtoRes;
    }

}
