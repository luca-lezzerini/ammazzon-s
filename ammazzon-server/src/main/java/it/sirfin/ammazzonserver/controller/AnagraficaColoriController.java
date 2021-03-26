/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ColoreDto;
import it.sirfin.ammazzonserver.dto.ListaColoriDto;
import it.sirfin.ammazzonserver.dto.RicercaColoreDto;
import it.sirfin.ammazzonserver.service.AnagraficaColoriService;
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
public class AnagraficaColoriController {

    @Autowired
    AnagraficaColoriService anagraficaColoriService;

    @RequestMapping("aggiungi-colore")
    @ResponseBody
    public ListaColoriDto aggiungiColore(@RequestBody ColoreDto dto) {
        return anagraficaColoriService.aggiungiColore(dto.getVarianteColore());
    }

    @RequestMapping("aggiorna-colore")
    public ListaColoriDto aggiornaColore() {
        return anagraficaColoriService.aggiornaColori();
    }

     @RequestMapping("modifica-colore")
    @ResponseBody
    public ListaColoriDto modificaColore(@RequestBody ColoreDto dto) {
        return anagraficaColoriService.modificaColore(dto.getVarianteColore());
    }
     @RequestMapping("ricerca-colore")
    @ResponseBody
    public ListaColoriDto ricercaColore(@RequestBody RicercaColoreDto dto) {
        return anagraficaColoriService.ricercaColore(dto.getCriterioRicerca());
    }
}
