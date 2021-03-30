/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.RicercaUtenteDto;
import it.sirfin.ammazzonserver.dto.UtenteRegistratoDto;
import it.sirfin.ammazzonserver.model.UtenteRegistrato;
import it.sirfin.ammazzonserver.service.AnagraficaUtenteRegistratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AnagraficaUtenteRegistratoController {

    @Autowired
    AnagraficaUtenteRegistratoService anagraficaUtenteRegistratoService;

    @RequestMapping("/aggiorna-utente")
    @ResponseBody
    public ListaPagineDto<UtenteRegistrato> aggiornaUtente() {
        return anagraficaUtenteRegistratoService.aggiorna(1);
    }

    @RequestMapping("aggiungi-utente")
    @ResponseBody
    public ListaPagineDto<UtenteRegistrato> aggiungiColore(@RequestBody UtenteRegistratoDto dto) {
        return anagraficaUtenteRegistratoService.aggiungiUtente(dto.getUtenteRegistrato());
    }

    @RequestMapping("rimuovi-utente")
    @ResponseBody
    public ListaPagineDto<UtenteRegistrato> rimuoviTaglia(@RequestBody UtenteRegistratoDto dto) {
        return anagraficaUtenteRegistratoService.rimuoviUtente(dto.getUtenteRegistrato());
    }

    @RequestMapping("conferma-utente")
    @ResponseBody
    public ListaPagineDto<UtenteRegistrato> confermaTaglia(@RequestBody UtenteRegistratoDto dto) {
        return anagraficaUtenteRegistratoService.conferma(dto.getUtenteRegistrato());
    }

    @RequestMapping("rit-utente")
    @ResponseBody
    public UtenteRegistratoDto ritornaTaglia(@RequestBody UtenteRegistratoDto dto) {
        return anagraficaUtenteRegistratoService.ritornaUtente(dto.getUtenteRegistrato());
    }

    @RequestMapping("ricerca-utente")
    @ResponseBody
    public ListaPagineDto<UtenteRegistrato> confermaTaglia(@RequestBody RicercaUtenteDto dto) {
        return anagraficaUtenteRegistratoService.ricerca(dto.getCriterioRicerca(), dto.getPagina());
    }

}
