/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaColoriDto;
import it.sirfin.ammazzonserver.model.VarianteColore;

/**
 *
 * @author manue
 */
public interface AnagraficaColoriService {

    ListaColoriDto aggiungiColore(VarianteColore vc);

    ListaColoriDto aggiornaColori();
    
    ListaColoriDto modificaColore(VarianteColore vc);
}
