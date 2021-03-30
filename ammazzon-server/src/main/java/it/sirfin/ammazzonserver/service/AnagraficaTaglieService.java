/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaTaglieDto;
import it.sirfin.ammazzonserver.dto.TagliaDto;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import org.springframework.data.domain.Page;

/**
 *
 * @author Admin
 */
public interface AnagraficaTaglieService {

    ListaTaglieDto aggiungiTaglia(VarianteTaglia vt);

    ListaTaglieDto rimuoviTaglia(VarianteTaglia vt);

    ListaTaglieDto ricerca(String c);

    TagliaDto ritornaTaglia(VarianteTaglia vt);

    ListaTaglieDto conferma(VarianteTaglia vt);

    ListaTaglieDto aggiorna();
    
   
}
