/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.ListaUtentiRegistratiDto;
import it.sirfin.ammazzonserver.dto.UtenteRegistratoDto;
import it.sirfin.ammazzonserver.model.UtenteRegistrato;

/**
 *
 * @author Palo
 */
public interface AnagraficaUtenteRegistratoService {

    ListaPagineDto<UtenteRegistrato> aggiungiUtente(UtenteRegistrato ur);

    ListaPagineDto<UtenteRegistrato> rimuoviUtente(UtenteRegistrato ur);

    ListaPagineDto<UtenteRegistrato> ricerca(String c, int pagina);

    UtenteRegistratoDto ritornaUtente(UtenteRegistrato ur);

    ListaPagineDto<UtenteRegistrato> conferma(UtenteRegistrato ur);

    ListaPagineDto<UtenteRegistrato> aggiorna(int pagina);
}
