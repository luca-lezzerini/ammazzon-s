/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ListaTaglieDto;
import it.sirfin.ammazzonserver.dto.RicercaTagliaDto;
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
//@CrossOrigin("*")
//@RestController
//public class AnagraficaTaglieController {
//
//    @Autowired
//    AnagraficaTaglieService anagraficaTaglieService;
//
//    @RequestMapping("/aggiorna-taglia")
//    @ResponseBody
//    public ListaTaglieDto aggiornaTaglie() {
//        return anagraficaTaglieService.aggiorna();
//    }
//
//    @RequestMapping("aggiungi-taglia")
//    @ResponseBody
//    public ListaTaglieDto aggiungiColore(@RequestBody TagliaDto dto) {
//        return anagraficaTaglieService.aggiungiTaglia(dto.getVarianteTaglia());
//    }
//
//    @RequestMapping("rimuovi-taglia")
//    @ResponseBody
//    public ListaTaglieDto rimuoviTaglia(@RequestBody TagliaDto dto) {
//        return anagraficaTaglieService.rimuoviTaglia(dto.getVarianteTaglia());
//    }
//
//    @RequestMapping("conferma-taglia")
//    @ResponseBody
//    public ListaTaglieDto confermaTaglia(@RequestBody TagliaDto dto) {
//        return anagraficaTaglieService.conferma(dto.getVarianteTaglia());
//    }
//
//    @RequestMapping("rit-taglia")
//    @ResponseBody
//    public TagliaDto ritornaTaglia(@RequestBody TagliaDto dto) {
//        return anagraficaTaglieService.ritornaTaglia(dto.getVarianteTaglia());
//    }
//
////    @RequestMapping("ricerca-taglia")
////    @ResponseBody
////    public ListaTaglieDto confermaTaglia(@RequestBody RicercaTagliaDto dto) {
////        return anagraficaTaglieService.ricerca(dto.getCriterioRicerca());
////    }
//    
//
//    
//}
