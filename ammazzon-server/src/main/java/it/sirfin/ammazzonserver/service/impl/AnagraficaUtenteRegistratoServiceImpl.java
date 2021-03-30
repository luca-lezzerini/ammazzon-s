/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.ListaUtentiRegistratiDto;
import it.sirfin.ammazzonserver.dto.UtenteRegistratoDto;
import it.sirfin.ammazzonserver.model.UtenteRegistrato;
import it.sirfin.ammazzonserver.repository.UtenteRegistratoRepository;
import it.sirfin.ammazzonserver.service.AnagraficaUtenteRegistratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaUtenteRegistratoServiceImpl implements AnagraficaUtenteRegistratoService {

    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;

    @Override
    public ListaPagineDto<UtenteRegistrato> aggiungiUtente(UtenteRegistrato ur) {
        utenteRegistratoRepository.save(ur);
        return aggiorna(1);
    }

    @Override
    public ListaPagineDto<UtenteRegistrato> rimuoviUtente(UtenteRegistrato ur) {
        utenteRegistratoRepository.delete(ur);
        return aggiorna(1);
    }

    @Override
    public UtenteRegistratoDto ritornaUtente(UtenteRegistrato ur) {
        return new UtenteRegistratoDto(ur);
    }

    @Override
    public ListaPagineDto<UtenteRegistrato> conferma(UtenteRegistrato ur) {
        utenteRegistratoRepository.save(ur);
        return aggiorna(1);
    }

    @Override
    public ListaPagineDto<UtenteRegistrato> aggiorna(int pagina) {
        Page<UtenteRegistrato> page = utenteRegistratoRepository.findAll(PageRequest.of(pagina, 3));
        return new ListaPagineDto<UtenteRegistrato>(
                page.getContent(),  // lista elementi nella pagina
                page.getPageable().getPageNumber(),     // numero della pagina corrente
                page.getTotalPages());  // numero complessivo di pagine
    }

    @Override
    public ListaPagineDto<UtenteRegistrato> ricerca(String c, int pagina) {
        Page<UtenteRegistrato> page = utenteRegistratoRepository.trovaUtenteRegistrato(c, PageRequest.of(pagina, 3));
        return new ListaPagineDto<UtenteRegistrato>(
                page.getContent(),  // lista elementi nella pagina
                page.getPageable().getPageNumber(),     // numero della pagina corrente
                page.getTotalPages());  // numero complessivo di pagine
    }

}
