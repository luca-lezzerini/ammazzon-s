/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaUtentiRegistratiDto;
import it.sirfin.ammazzonserver.dto.UtenteRegistratoDto;
import it.sirfin.ammazzonserver.model.UtenteRegistrato;

/**
 *
 * @author Palo
 */
public interface AnagraficaUtenteRegistratoService {

    ListaUtentiRegistratiDto aggiungiUtente(UtenteRegistrato ur);

    ListaUtentiRegistratiDto rimuoviUtente(UtenteRegistrato ur);

    ListaUtentiRegistratiDto ricerca(String c);

    UtenteRegistratoDto ritornaUtente(UtenteRegistrato ur);

    ListaUtentiRegistratiDto conferma(UtenteRegistrato ur);

    ListaUtentiRegistratiDto aggiorna();
}
