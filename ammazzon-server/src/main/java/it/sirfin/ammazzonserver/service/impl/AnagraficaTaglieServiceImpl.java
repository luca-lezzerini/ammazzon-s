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
    public Page <VarianteTaglia>  aggiungiTaglia(VarianteTaglia vt, int pagina) {
        varianteTagliaRepository.save(vt);
        return aggiorna(pagina);
    }

    @Override
    public Page <VarianteTaglia>  rimuoviTaglia(VarianteTaglia vt, int pagina) {
        varianteTagliaRepository.delete(vt);
        return aggiorna(pagina);
    }

    @Override
    public Page<VarianteTaglia> ricerca(String c, int pagina) {
        if (c.isBlank()) {
            return aggiorna(pagina);
        }
        Pageable primaPaginaCinqueElementi = PageRequest.of(0, 5);
        Page<VarianteTaglia> lista = varianteTagliaRepository.trovaCodice(c,primaPaginaCinqueElementi);
        return lista;
    }

    @Override
    public TagliaDto ritornaTaglia(VarianteTaglia vt, int pagina) {
        return new TagliaDto(vt);
    }

    @Override
    public Page<VarianteTaglia> conferma(VarianteTaglia vt, int pagina) {
        varianteTagliaRepository.save(vt);
        return aggiorna(pagina);
    }

    @Override
    public Page<VarianteTaglia> aggiorna(int pagina) {
        Pageable primaPaginaCinqueElementi = PageRequest.of(pagina, 5);
        Page<VarianteTaglia> lista = varianteTagliaRepository.findAll(primaPaginaCinqueElementi);
        lista.forEach(l -> {
            l.setColoriTaglie(new ArrayList<>());
        });
        return lista;
    }

}
