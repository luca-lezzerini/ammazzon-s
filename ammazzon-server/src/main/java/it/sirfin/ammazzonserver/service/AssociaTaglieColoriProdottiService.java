package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaColoreTagliaDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.VarianteTaglia;

public interface AssociaTaglieColoriProdottiService {

    ListaProdottiDto cercaProdotti(String criterioRic);

    ListaProdottoColoriDto selezionaProdotto(Long idProdotto);
    
    ListaColoreTagliaDto selezionaProdottoColore(Long idProdottoColore);
    
    ListaColoreTagliaDto disassociaTaglia(Long idColoreTaglia, Long idProdottoColore);
    
    ListaColoreTagliaDto associaTaglia(ProdottoColore pc, VarianteTaglia vt);
    
    ListaColoreTagliaDto disassociaTutti(Long idProdottoColore);
    
    ListaColoreTagliaDto associaTutti(Long idProdottoColore);
}
