/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.UtenteRegistrato;
import java.util.List;

/**
 *
 * @author Palo
 */
public class ListaUtentiRegistratiDto {

    private List<UtenteRegistrato> listaUtentiRegistrati;
    private Integer numPag;
    private Integer totalPages;

    public ListaUtentiRegistratiDto() {
    }

    public ListaUtentiRegistratiDto(List<UtenteRegistrato> listaUtentiRegistrati, Integer numPag, Integer totalPages) {
        this.listaUtentiRegistrati = listaUtentiRegistrati;
        this.numPag = numPag;
        this.totalPages = totalPages;
    }

    public List<UtenteRegistrato> getListaUtentiRegistrati() {
        return listaUtentiRegistrati;
    }

    public void setListaUtentiRegistrati(List<UtenteRegistrato> listaUtentiRegistrati) {
        this.listaUtentiRegistrati = listaUtentiRegistrati;
    }

    public Integer getNumPag() {
        return numPag;
    }

    public void setNumPag(Integer numPag) {
        this.numPag = numPag;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
    
    
    

}
