package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaColoreTagliaDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.VarianteTaglia;

public interface AssociaTaglieColoriProdottiService {

    ListaProdottiDto cercaProdotti(String criterioRic);

    ListaProdottoColoriDto coloriAssociatiProdotto(Long idProdotto);
    
    ListaColoreTagliaDto coloriTaglieAssociateProdottoColore(Long idProdottoColore);
    
    ListaColoreTagliaDto disassociaTaglia(Long idColoreTaglia, Long idProdottoColore);
    
    ListaColoreTagliaDto associaTaglia(ProdottoColore pc, VarianteTaglia vt);
}
