/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.UtenteRegistrato;

/**
 *
 * @author Palo
 */
public class UtenteRegistratoDto {

    private UtenteRegistrato utenteRegistrato;

    public UtenteRegistratoDto() {
    }

    public UtenteRegistratoDto(UtenteRegistrato utenteRegistrato) {
        this.utenteRegistrato = utenteRegistrato;
    }

    public UtenteRegistrato getUtenteRegistrato() {
        return utenteRegistrato;
    }

    public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
        this.utenteRegistrato = utenteRegistrato;
    }

    @Override
    public String toString() {
        return "UtenteRegistratoDto{" + "utenteRegistrato=" + utenteRegistrato + '}';
    }

}
