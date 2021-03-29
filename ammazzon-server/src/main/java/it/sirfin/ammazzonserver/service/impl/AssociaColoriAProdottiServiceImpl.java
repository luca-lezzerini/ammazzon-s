/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.VarianteColore;
import it.sirfin.ammazzonserver.repository.ProdottoColoreRepository;
import it.sirfin.ammazzonserver.repository.ProdottoRepository;
import it.sirfin.ammazzonserver.repository.VarianteColoreRepository;
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
    @Autowired
    ProdottoColoreRepository prodottoColoreRepository;
    @Autowired
    VarianteColoreRepository varianteColoreRepository;

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

    @Override
    public ListaProdottoColoriDto selezionaProdotto(Long id) {

        return new ListaProdottoColoriDto(prodottoColoreRepository.selezionaProdotto(id));
    }

    @Override
    public ListaProdottoColoriDto spostaNonAssociati(Long idProd, Long idCol) {
        //Recupero prodotto da db

        //Recuperare colore da db
        //ProdottoColore pc = prodottoColoreRepository.findById(id).get();
        //TROVA L?UNICO PRODOTTO_COLORE CON IL PRODOTTO E COLORE DATI
        ProdottoColore pc = new ProdottoColore();
        pc = prodottoColoreRepository.trovaProdottoColore(idProd, idCol);
        //RIMUOVE LE DUE ASSOCIAZIONI CHE FANNO PERNO SU PRODOTTO_COLORE 
        //RIMUOVERE PRODOTTO COLORE
        //Rimuovere colore dall'associazione con prodotto
        System.out.println("--------------" + pc.getId() + "fungeeeeeeeeeeeeeeeeeeeeeeeee");
        pc.setVarianteColore(new VarianteColore());     
        //Rimuovere prodotto dall'associazione con colore
        pc.setProdotto(null);
        //Salvare entrambi
        prodottoColoreRepository.save(pc);
        //Riaggiornare le liste che vanno inserite nelle tabelle e ritornarle
        return aggiornaProdottiColore();
    }

    
    @Override
    public ListaProdottoColoriDto aggiornaProdottiColore() {
        return new ListaProdottoColoriDto(prodottoColoreRepository.findAll());
    }
}
