/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaPagineDto;
import it.sirfin.ammazzonserver.dto.TagliaDto;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import org.springframework.data.domain.Page;

/**
 *
 * @author Admin
 */
public interface AnagraficaTaglieService {

    ListaPagineDto<VarianteTaglia> aggiungiTaglia(VarianteTaglia vt, int pagina, int totalPages);

    ListaPagineDto<VarianteTaglia> rimuoviTaglia(VarianteTaglia vt, int pagina, int totalPages);

    ListaPagineDto<VarianteTaglia> ricerca(String c, int pagina, int totalPages);

    TagliaDto ritornaTaglia(VarianteTaglia vt, int pageNum);

    ListaPagineDto<VarianteTaglia> conferma(VarianteTaglia vt, int pagina, int totalPages);

    ListaPagineDto<VarianteTaglia> aggiornaListaPaginata(int pagina, int totalPages);

}
