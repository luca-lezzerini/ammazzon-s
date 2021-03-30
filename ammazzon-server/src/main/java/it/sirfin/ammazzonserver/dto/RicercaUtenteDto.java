/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

/**
 *
 * @author Palo
 */
public class RicercaUtenteDto {

    private String criterioRicerca;
    private int pagina;

    public RicercaUtenteDto() {
    }

    public RicercaUtenteDto(int pagina) {
        this.pagina = pagina;
    }

    public String getCriterioRicerca() {
        return criterioRicerca;
    }

    public void setCriterioRicerca(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

}
