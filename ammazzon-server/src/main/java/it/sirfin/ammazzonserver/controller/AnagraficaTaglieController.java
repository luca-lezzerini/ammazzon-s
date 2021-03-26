/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ListaTaglieDto;
import it.sirfin.ammazzonserver.dto.TagliaDto;
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
@RestController
@CrossOrigin("*")
public class AnagraficaTaglieController {

    @Autowired
    AnagraficaTaglieService anagraficaTaglieService;

    @RequestMapping("add-taglia")
    @ResponseBody
    public ListaTaglieDto aggiungiTaglia(@RequestBody TagliaDto dto) {
        return anagraficaTaglieService.aggiungiTaglia(dto.getVarianteTaglia());
    }

    @RequestMapping("rim-taglia")
    @ResponseBody
    public ListaTaglieDto rimuoviTaglia(@RequestBody TagliaDto dto) {
        return anagraficaTaglieService.rimuoviTaglia(dto.getVarianteTaglia());
    }

    @RequestMapping("conf-taglia")
    @ResponseBody
    public ListaTaglieDto confermaModifica(@RequestBody TagliaDto dto) {
        return anagraficaTaglieService.conferma(dto.getVarianteTaglia());
    }

}
