/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaTaglieDto;
import it.sirfin.ammazzonserver.dto.PaginaDto;
import it.sirfin.ammazzonserver.dto.TagliaDto;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import it.sirfin.ammazzonserver.repository.VarianteTagliaRepository;
import it.sirfin.ammazzonserver.service.AnagraficaTaglieService;
import java.util.ArrayList;
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

    @Autowired
    VarianteTagliaRepository varianteTagliaRepository;

    @Override
    public Page <VarianteTaglia>  aggiungiTaglia(VarianteTaglia vt, int pagina, int totalPages) {
        varianteTagliaRepository.save(vt);
        return aggiorna(pagina,totalPages);
    }

    @Override
    public Page <VarianteTaglia>  rimuoviTaglia(VarianteTaglia vt, int pagina, int totalPages) {
        varianteTagliaRepository.delete(vt);
        return aggiorna(pagina,totalPages);
    }

    @Override
    public Page<VarianteTaglia> ricerca(String c, int pageNum, int totalPages) {
        if (c.isBlank()) {
            return aggiorna(pageNum,totalPages);
        }
        Pageable primaPaginaCinqueElementi = PageRequest.of(pageNum, totalPages);
        Page<VarianteTaglia> lista = varianteTagliaRepository.trovaCodice(c,primaPaginaCinqueElementi);
        return lista;
    }

    @Override
    public TagliaDto ritornaTaglia(VarianteTaglia vt, int pageNum, int totalPages) {
        return new TagliaDto(vt, pageNum, totalPages);
    }

    @Override
    public Page<VarianteTaglia> conferma(VarianteTaglia vt, int pagina, int totalPages) {
        varianteTagliaRepository.save(vt);
        return aggiorna(pagina,totalPages);
    }

    @Override
    public Page<VarianteTaglia> aggiorna(int pagina, int totalPages) {
        Pageable primaPaginaCinqueElementi = PageRequest.of(pagina, totalPages);
        Page<VarianteTaglia> lista = varianteTagliaRepository.findAll(primaPaginaCinqueElementi);
        lista.forEach(l -> {
            l.setColoriTaglie(new ArrayList<>());
        });
        return lista;
    }

}
