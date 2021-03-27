/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

/**
 *
 * @author Admin
 */
public class RicercaColoreOProdottoDto {

    private String criterioRicerca;

    public RicercaColoreOProdottoDto() {
    }

    public RicercaColoreOProdottoDto(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    public String getCriterioRicerca() {
        return criterioRicerca;
    }

    public void setCriterioRicerca(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    @Override
    public String toString() {
        return "RicercaTagliaDto{" + "criterioRicerca=" + criterioRicerca + '}';
    }

}
