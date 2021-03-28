package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.ListaColoriDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.dto.ProdottoDto;
import it.sirfin.ammazzonserver.dto.RicercaStringaReqDto;
import it.sirfin.ammazzonserver.service.AssociaTaglieColoriProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AssociaTaglieColoriProdottiController {
    @Autowired
    AssociaTaglieColoriProdottiService associaTaglieColoriProdottiService;

    @RequestMapping("cerca-prodotti-codice-esatto-descrizione-like")
    @ResponseBody
    ListaProdottiDto cercaProdotti(@RequestBody RicercaStringaReqDto dto){
        return associaTaglieColoriProdottiService
                .cercaProdotti(dto.getCriterioRicerca());
    }
    
    @RequestMapping("cerca-colori-associati-prodotto")
    @ResponseBody
    ListaProdottoColoriDto cercaColoriAssociatiProdotto(@RequestBody ProdottoDto dto){
        return associaTaglieColoriProdottiService
                .coloriAssociatiProdotto(dto.getProdotto().getId());
    }
    
    
}
