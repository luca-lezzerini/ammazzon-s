/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.dto.ProdottoDto;
import it.sirfin.ammazzonserver.dto.RicercaColoreOProdottoDto;
import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.service.AssociaColoriAProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manue
 */
@RestController
@CrossOrigin("*")
public class AssociaColoriAProdottiController {

    @Autowired
    AssociaColoriAProdottiService associaColoriAProdottiService;

    

    @RequestMapping("cerca-prodotto")
    @ResponseBody
    public ListaProdottiDto ricercaProdotto(@RequestBody RicercaColoreOProdottoDto dto) {
        return associaColoriAProdottiService.ricercaProdotto(dto.getCriterioRicerca());
    }
    
    @RequestMapping ("seleziona-prodotto")
    @ResponseBody
    public ListaProdottoColoriDto selezionaProdotto (@RequestBody ProdottoDto dto){
        return associaColoriAProdottiService.selezionaProdotto(dto.getProdotto());
    }

 
}
