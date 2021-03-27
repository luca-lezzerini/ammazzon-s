/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service.impl;

import it.sirfin.ammazzonserver.dto.ListaUtentiRegistratiDto;
import it.sirfin.ammazzonserver.dto.UtenteRegistratoDto;
import it.sirfin.ammazzonserver.model.UtenteRegistrato;
import it.sirfin.ammazzonserver.repository.UtenteRegistratoRepository;
import it.sirfin.ammazzonserver.service.AnagraficaUtenteRegistratoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaUtenteRegistratoServiceImpl implements AnagraficaUtenteRegistratoService {

    @Autowired
    UtenteRegistratoRepository utenteRegistratoRepository;

    @Override
    public ListaUtentiRegistratiDto aggiungiUtente(UtenteRegistrato ur) {
        utenteRegistratoRepository.save(ur);
        return aggiorna();
    }

    @Override
    public ListaUtentiRegistratiDto rimuoviUtente(UtenteRegistrato ur) {
        utenteRegistratoRepository.delete(ur);
        return aggiorna();
    }

    @Override
    public ListaUtentiRegistratiDto ricerca(String c) {
        List<UtenteRegistrato> lista = utenteRegistratoRepository.trovaUtenteRegistrato(c);
        return new ListaUtentiRegistratiDto(lista);
    }

    @Override
    public UtenteRegistratoDto ritornaUtente(UtenteRegistrato ur) {
        return new UtenteRegistratoDto(ur);
    }

    @Override
    public ListaUtentiRegistratiDto conferma(UtenteRegistrato ur) {
        utenteRegistratoRepository.save(ur);
        return aggiorna();
    }

    @Override
    public ListaUtentiRegistratiDto aggiorna() {
        List<UtenteRegistrato> lista = utenteRegistratoRepository.findAll();
        return new ListaUtentiRegistratiDto(lista);
    }

}
