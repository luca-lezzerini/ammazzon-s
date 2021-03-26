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

    public ListaUtentiRegistratiDto() {
    }

    public ListaUtentiRegistratiDto(List<UtenteRegistrato> listaUtentiRegistrati) {
        this.listaUtentiRegistrati = listaUtentiRegistrati;
    }

    public List<UtenteRegistrato> getListaUtentiRegistrati() {
        return listaUtentiRegistrati;
    }

    public void setListaUtentiRegistrati(List<UtenteRegistrato> listaUtentiRegistrati) {
        this.listaUtentiRegistrati = listaUtentiRegistrati;
    }

    @Override
    public String toString() {
        return "ListaUtentiRegistratiDto{" + "listaUtentiRegistrati=" + listaUtentiRegistrati + '}';
    }

}
