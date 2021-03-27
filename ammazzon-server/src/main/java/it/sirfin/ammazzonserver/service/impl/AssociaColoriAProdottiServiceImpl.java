/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.service.AssociaColoriAProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manue
 */
@Service
public class AssociaColoriAProdottiServiceImpl implements AssociaColoriAProdottiService {

    @Autowired
    ProdottoRepository prodottoRepository;

   

    @Override
    public ListaProdottiDto aggiornaProdotti() {
        return new ListaProdottiDto(prodottoRepository.findAll());

    }

   
    @Override
    public ListaProdottiDto ricercaProdotto(String c) {
        if (c.isBlank()) {
            return aggiornaProdotti();
        }
        return new ListaProdottiDto(prodottoRepository.trovaCodiceODescrizione(c));
    }

 
}
