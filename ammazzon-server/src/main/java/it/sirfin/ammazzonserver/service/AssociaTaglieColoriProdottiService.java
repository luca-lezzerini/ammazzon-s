package it.sirfin.ammazzonserver.service;

import it.sirfin.ammazzonserver.dto.ListaColoreTagliaDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;

public interface AssociaTaglieColoriProdottiService {

    ListaProdottiDto cercaProdotti(String criterioRic);

    ListaProdottoColoriDto coloriAssociatiProdotto(Long idProdotto);
    
    ListaColoreTagliaDto coloriTaglieAssociateProdottoColore(Long idProdottoColore);
    
    ListaColoreTagliaDto disassociaTaglia(Long idColoreTaglia, Long idProdottoColore);
}
