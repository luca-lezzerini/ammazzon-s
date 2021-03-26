/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaColoriDto;
import it.sirfin.ammazzonserver.model.VarianteColore;
import it.sirfin.ammazzonserver.repository.VarianteColoreRepository;
import it.sirfin.ammazzonserver.service.AnagraficaColoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manue
 */
@Service
public class AnagraficaColoriServiceImpl implements AnagraficaColoriService {

    @Autowired
    VarianteColoreRepository varianteColoreRepository;

    @Override
    public ListaColoriDto aggiungiColore(VarianteColore vc) {
        varianteColoreRepository.save(vc);
        return aggiornaColori();

    }

    @Override
    public ListaColoriDto aggiornaColori() {
        return new ListaColoriDto(varianteColoreRepository.findAll());

    }

    @Override
    public ListaColoriDto modificaColore(VarianteColore vc) {
        varianteColoreRepository.save(vc);
        return aggiornaColori();
    }

}
