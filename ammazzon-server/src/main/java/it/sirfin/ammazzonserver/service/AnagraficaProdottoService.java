/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ProdottoDto;
import it.sirfin.ammazzonserver.model.Prodotto;

public interface AnagraficaProdottoService {

    ListaProdottiDto inserisci(Prodotto p);

    ListaProdottiDto elimina(Prodotto p);

    ListaProdottiDto modifica(Prodotto p);

    ProdottoDto seleziona(Prodotto p);

    ListaPagineDto<Prodotto> ricerca(String criterio,int numeroPagina);

    ListaProdottiDto aggiorna();
    
    ListaPagineDto<Prodotto> ricercaProdottiPaginata(String criterioRicerca, int numeroPagina);
}
