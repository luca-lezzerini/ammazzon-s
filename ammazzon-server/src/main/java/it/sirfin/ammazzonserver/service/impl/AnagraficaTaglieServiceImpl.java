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
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

///**
// *
// * @author Admin
// */
//@Service
//public class AnagraficaTaglieServiceImpl implements AnagraficaTaglieService {
//
//    @Autowired
//    VarianteTagliaRepository varianteTagliaRepository;
//
//    @Override
//    public ListaTaglieDto aggiungiTaglia(VarianteTaglia vt) {
//        varianteTagliaRepository.save(vt);
//        return aggiorna();
//    }
//
//    @Override
//    public ListaTaglieDto rimuoviTaglia(VarianteTaglia vt) {
//        varianteTagliaRepository.delete(vt);
//        return aggiorna();
//    }
//
//    @Override
//    public Page<VarianteTaglia> ricerca(String c) {
//        if (c.isBlank()) {
//            return aggiorna();
//        }
//        Page<VarianteTaglia> lista = varianteTagliaRepository.trovaCodice(c, );
//        return lista;
//    }
//
//    @Override
//    public TagliaDto ritornaTaglia(VarianteTaglia vt) {
//        return new TagliaDto(vt);
//    }
//
//    @Override
//    public ListaTaglieDto conferma(VarianteTaglia vt) {
//        varianteTagliaRepository.save(vt);
//        return aggiorna();
//    }
//
//    @Override
//    public Page <VarianteTaglia> aggiorna( ) {
//        
//        Page<VarianteTaglia> lista = varianteTagliaRepository.findAll();
//        lista.forEach(l -> {
//            l.setColoriTaglie(new ArrayList<>());
//        });
//        return lista;
//    }
//
//}
