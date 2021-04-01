/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaTaglieDto;
import it.sirfin.ammazzonserver.dto.TagliaDto;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import it.sirfin.ammazzonserver.repository.VarianteTagliaRepository;
import it.sirfin.ammazzonserver.service.AnagraficaTaglieService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class AnagraficaTaglieServiceImpl implements AnagraficaTaglieService {

    static final Logger logger = LoggerFactory.getLogger(AnagraficaTaglieServiceImpl.class);

    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;

    @Override
    public Page<VarianteTaglia> aggiungiTaglia(VarianteTaglia vt, int pagina, int totalPages) {
        varianteTagliaRepository.save(vt);
        return aggiornaListaPaginata(pagina, 3);
    }

    @Override
    public Page<VarianteTaglia> rimuoviTaglia(VarianteTaglia vt, int pagina, int totalPages) {
        varianteTagliaRepository.delete(vt);
        return aggiornaListaPaginata(pagina, 3);
    }

    @Override
    public Page<VarianteTaglia> ricerca(String c, int pageNum, int totalPages) {
        if (c.isBlank()) {
            return aggiornaListaPaginata(pageNum, 3);
        }
        Pageable primaPaginaCinqueElementi = PageRequest.of(pageNum, 3);
        Page<VarianteTaglia> lista = varianteTagliaRepository.trovaCodice(c, primaPaginaCinqueElementi);
        logger.debug(lista.toString());
        return lista;
    }

    @Override
    public TagliaDto ritornaTaglia(VarianteTaglia vt, int pageNum) {
        return new TagliaDto(vt, pageNum);
    }

    @Override
    public Page<VarianteTaglia> conferma(VarianteTaglia vt, int pagina, int totalPages) {
        varianteTagliaRepository.save(vt);
        return aggiornaListaPaginata(pagina, 3);
    }

    @Override
    public Page<VarianteTaglia> aggiornaListaPaginata(int pagina, int totalPages) {
        Pageable primaPaginaCinqueElementi = PageRequest.of(pagina - 1, 2);
        Page<VarianteTaglia> lista = varianteTagliaRepository.findAll(primaPaginaCinqueElementi);
        logger.debug(lista.toString());
        return lista;
    }

  

}
