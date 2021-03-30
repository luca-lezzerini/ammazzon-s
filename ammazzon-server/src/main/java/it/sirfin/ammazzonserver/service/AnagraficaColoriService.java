/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ColoreDto;
import it.sirfin.ammazzonserver.dto.ListaColoriDto;
import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.model.VarianteColore;

/**
 *
 * @author manue
 */
public interface AnagraficaColoriService {

    ListaPagineDto<VarianteColore> aggiungiColore(VarianteColore vc, int pagina);

    ListaPagineDto<VarianteColore> aggiornaColori(int pagina);

    ListaPagineDto<VarianteColore> modificaColore(VarianteColore vc, int pagina);

    ListaPagineDto<VarianteColore> ricercaColore(String c, int pagina);

    ListaPagineDto<VarianteColore> rimuoviColore(VarianteColore vc, int pagina);

    ColoreDto ritornaColore(VarianteColore vc, Integer pageNum, Integer totalPages);

    ListaPagineDto<VarianteColore> ritornaRecordPaginati(int pagina);
}
