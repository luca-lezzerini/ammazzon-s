/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.ProdottoColore;
import java.util.List;

public class ListaProdottoColoriDto {

    private List<ProdottoColore> listaProdottoColori;

    public ListaProdottoColoriDto() {
    }

    
    public ListaProdottoColoriDto(List<ProdottoColore> listaProdottoColori) {
        this.listaProdottoColori = listaProdottoColori;
    }

    public List<ProdottoColore> getListaProdottoColori() {
        return listaProdottoColori;
    }

    public void setListaProdottoColori(List<ProdottoColore> listaProdottoColori) {
        this.listaProdottoColori = listaProdottoColori;
    }

    @Override
    public String toString() {
        return "ListaProdottoColoriDto{" + "listaProdottoColori=" + listaProdottoColori + '}';
    }

}
