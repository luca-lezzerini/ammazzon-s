/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ChiediPaginaDto;
import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.PaginaCompletaDto;
import it.sirfin.ammazzonserver.dto.ProdottoDto;
import it.sirfin.ammazzonserver.dto.RicercaProdottoDto;
import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.service.AnagraficaProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AnagraficaProdottoController {

    @Autowired
    AnagraficaProdottoService anagraficaProdottoService;

    @RequestMapping("/aggiungi-prodotto")
    @ResponseBody
    public ListaProdottiDto inserisci(@RequestBody ProdottoDto dto) {

        return anagraficaProdottoService.inserisci(dto.getProdotto());
    }

    @RequestMapping("aggiorna-prodotti")
    @ResponseBody
    public ListaProdottiDto aggiorna(@RequestBody PaginaCompletaDto pag) {
        return anagraficaProdottoService.aggiorna();
    }

    @RequestMapping("rimuovi-prodotto")
    @ResponseBody
    public ListaProdottiDto elimina(@RequestBody ProdottoDto dto) {
        return anagraficaProdottoService.elimina(dto.getProdotto());
    }

    @RequestMapping("conferma-prodotto")
    @ResponseBody
    public ListaProdottiDto confermaProdotto(@RequestBody ProdottoDto dto) {
        return anagraficaProdottoService.modifica(dto.getProdotto());
    }

    @RequestMapping("seleziona-prodotti")
    @ResponseBody
    public ProdottoDto selezionaProdotto(@RequestBody ProdottoDto dto) {
        return anagraficaProdottoService.seleziona(dto.getProdotto());
    }

    @RequestMapping("ricerca-prodotto")
    @ResponseBody
    public ListaPagineDto<Prodotto> cercaProdotto(@RequestBody ChiediPaginaDto dto) {
        return anagraficaProdottoService.ricerca(dto.getCriterioRicerca(), dto.getNumeroPagina()-1,dto.getNumeroRisultati());
    }

    @RequestMapping("ricerca-prodotti-paginata")
    @ResponseBody
    public ListaPagineDto<Prodotto> ricercaProdottiPaginata(@RequestBody ChiediPaginaDto dto) {
        return anagraficaProdottoService.ricercaProdottiPaginata(
                dto.getCriterioRicerca(), dto.getNumeroPagina());
    }

}
