package it.sirfin.ammazzonserver.controller;

import it.sirfin.ammazzonserver.dto.AssociaTagliaRequestDto;
import it.sirfin.ammazzonserver.dto.DisassociaTagliaRequestDto;
import it.sirfin.ammazzonserver.dto.ListaColoreTagliaDto;
import it.sirfin.ammazzonserver.dto.ListaProdottiDto;
import it.sirfin.ammazzonserver.dto.ListaProdottoColoriDto;
import it.sirfin.ammazzonserver.dto.ProdottoColoreDto;
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
    ListaProdottiDto cercaProdotti(@RequestBody RicercaStringaReqDto dto) {
        return associaTaglieColoriProdottiService
                .cercaProdotti(dto.getCriterioRicerca());
    }

    @RequestMapping("cerca-colori-associati-prodotto")
    @ResponseBody
    ListaProdottoColoriDto cercaColoriAssociatiProdotto(@RequestBody ProdottoDto dto) {
        return associaTaglieColoriProdottiService
                .coloriAssociatiProdotto(dto.getProdotto().getId());
    }

    @RequestMapping("cerca-ColoreTaglia-associati-prodottoColore")
    @ResponseBody
    ListaColoreTagliaDto coloriTaglieAssociateProdottoColore(@RequestBody ProdottoColoreDto dto) {
        ListaColoreTagliaDto dtoRes = associaTaglieColoriProdottiService
                .coloriTaglieAssociateProdottoColore(dto.getProdottoColore().getId());
        return dtoRes;
    }
    
    /**
     * disassocia una taglia dati in input IdColoreTaglia e IdProdottoColore
     * ritorna con taglie associate e non a prodotto selezionato da client
     * @param dtoReq
     * @return 
     */
    @RequestMapping("disassocia-taglia")
    @ResponseBody
    ListaColoreTagliaDto disassociaTaglia(@RequestBody DisassociaTagliaRequestDto dtoReq) {
        ListaColoreTagliaDto dtoRes = associaTaglieColoriProdottiService
                .disassociaTaglia(dtoReq.getIdColoreTaglia(), dtoReq.getIdProdottoColore());
        return dtoRes;
    }
   
    @RequestMapping("associa-taglia")
    @ResponseBody
    ListaColoreTagliaDto associaTaglia(@RequestBody AssociaTagliaRequestDto dtoReq) {
        ListaColoreTagliaDto dtoRes = associaTaglieColoriProdottiService
                .associaTaglia(dtoReq.getPc(), dtoReq.getVt());
        System.out.println("Ritorna dtoRes da associaTaglia");
        return dtoRes;
    }
    
    @RequestMapping("disassocia-tutti")
    @ResponseBody
    ListaColoreTagliaDto disassociaTutti(@RequestBody ProdottoColoreDto dto) {
        ListaColoreTagliaDto dtoRes = associaTaglieColoriProdottiService
                .disassociaTutti(dto.getProdottoColore().getId());
        return dtoRes;
    }
    
    

}
