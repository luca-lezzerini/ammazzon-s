/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.ListaTaglieDto;
import it.sirfin.ammazzonserver.dto.PaginaDto;
import it.sirfin.ammazzonserver.dto.RicercaTagliaDto;
import it.sirfin.ammazzonserver.dto.TagliaDto;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import it.sirfin.ammazzonserver.service.AnagraficaTaglieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@CrossOrigin("*")
@RestController
public class AnagraficaTaglieController {

    @Autowired
    AnagraficaTaglieService anagraficaTaglieService;

    @RequestMapping("/aggiorna-taglia")
    @ResponseBody
    public ListaPagineDto<VarianteTaglia> aggiornaTaglie(@RequestBody TagliaDto dto) {
        var pag = anagraficaTaglieService.aggiorna(dto.getPageNum(), 0);
        return new ListaPagineDto<>(pag.getContent(), pag.getPageable().getPageNumber(), pag.getTotalPages());
    }

    @RequestMapping("aggiungi-taglia")
    @ResponseBody
    public ListaPagineDto<VarianteTaglia> aggiungiColore(@RequestBody TagliaDto dto) {
        var pag = anagraficaTaglieService.aggiungiTaglia(dto.getVarianteTaglia(), dto.getPageNum(), 0);
        return new ListaPagineDto<>(pag.getContent(), pag.getPageable().getPageNumber(), pag.getTotalPages());
    }

    @RequestMapping("rimuovi-taglia")
    @ResponseBody
    public ListaPagineDto<VarianteTaglia> rimuoviTaglia(@RequestBody TagliaDto dto) {
        var pag = anagraficaTaglieService.rimuoviTaglia(dto.getVarianteTaglia(), dto.getPageNum(), 0);
        return new ListaPagineDto<>(pag.getContent(), pag.getPageable().getPageNumber(), pag.getTotalPages());
    }

    @RequestMapping("conferma-taglia")
    @ResponseBody
    public ListaPagineDto<VarianteTaglia> confermaTaglia(@RequestBody TagliaDto dto) {
        var pag = anagraficaTaglieService.conferma(dto.getVarianteTaglia(), dto.getPageNum(), 0);
        return new ListaPagineDto<>(pag.getContent(), pag.getPageable().getPageNumber(), pag.getTotalPages());
    }

    @RequestMapping("rit-taglia")
    @ResponseBody
    public TagliaDto ritornaTaglia(@RequestBody TagliaDto dto) {
        return anagraficaTaglieService.ritornaTaglia(dto.getVarianteTaglia(), dto.getPageNum());
    }

    @RequestMapping("ricerca-taglia")
    @ResponseBody
    public ListaPagineDto<VarianteTaglia> ricercaTaglia(@RequestBody RicercaTagliaDto dto) {
        var pag = anagraficaTaglieService.ricerca(dto.getCriterioRicerca(), dto.getPageNum(), dto.getTotalPages());
        return new ListaPagineDto<>(pag.getContent(), pag.getPageable().getPageNumber(), pag.getTotalPages());
    }
}
