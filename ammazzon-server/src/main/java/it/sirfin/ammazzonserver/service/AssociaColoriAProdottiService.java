/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaColoriDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.model.Prodotto;

/**
 *
 * @author manue
 */
public interface AssociaColoriAProdottiService {

    ListaProdottiDto ricercaProdotto(String c);

    ListaProdottiDto aggiornaProdotti();

    ListaProdottoColoriDto selezionaProdotto(Long id);
    
    ListaProdottoColoriDto spostaNonAssociati (Long idProd, Long idCol);
    
    ListaProdottoColoriDto aggiornaProdottiColore ();
}
