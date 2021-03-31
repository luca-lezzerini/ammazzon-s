/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ColoreDto;
import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.PaginaDto;
import it.sirfin.ammazzonserver.dto.RicercaColoreOProdottoDto;
import it.sirfin.ammazzonserver.model.VarianteColore;
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
    public ListaPagineDto<VarianteColore> aggiungiColore(@RequestBody ColoreDto dto) {
        return anagraficaColoriService.aggiungiColore(dto.getVarianteColore(), dto.getPageNum());
    }

    @RequestMapping("aggiorna-colore")
    public ListaPagineDto<VarianteColore> aggiornaColore(@RequestBody ColoreDto dto) {
        return anagraficaColoriService.aggiornaColori(dto.getPageNum());
    }

    @RequestMapping("modifica-colore")
    @ResponseBody
    public ListaPagineDto<VarianteColore> modificaColore(@RequestBody ColoreDto dto) {
        return anagraficaColoriService.modificaColore(dto.getVarianteColore(), 1);
    }

    @RequestMapping("ricerca-colore")
    @ResponseBody
    public ListaPagineDto<VarianteColore> ricercaColore(@RequestBody RicercaColoreOProdottoDto dto) {
        return anagraficaColoriService.ricercaColore(dto.getCriterioRicerca(), dto.getPageNum());
    }

    @RequestMapping("rimuovi-colore")
    @ResponseBody
    public ListaPagineDto<VarianteColore> rimuoviColore(@RequestBody ColoreDto dto) {
        return anagraficaColoriService.rimuoviColore(dto.getVarianteColore(), dto.getPageNum());
    }

    @RequestMapping("ritorna-colore")
    @ResponseBody
    public ColoreDto ritornaColore(@RequestBody ColoreDto dto) {
        return anagraficaColoriService.ritornaColore(dto.getVarianteColore(), dto.getPageNum(), dto.getTotalPages());
    }

    @RequestMapping("ritorna-colore-paginato")
    @ResponseBody
    public ListaPagineDto<VarianteColore> ritornaColorePaginato(@RequestBody PaginaDto dto) {
        return anagraficaColoriService.ritornaRecordPaginati(dto.getPageNum());
    }

}
