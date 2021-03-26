/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.VarianteColore;
import java.util.List;

/**
 *
 * @author manue
 */
public class ListaColoriDto {
    
    
    private List<VarianteColore> variantiColori;

    public ListaColoriDto() {
    }

    public ListaColoriDto(List<VarianteColore> variantiColori) {
        this.variantiColori = variantiColori;
    }

    public List<VarianteColore> getVariantiColori() {
        return variantiColori;
    }

    public void setVariantiColori(List<VarianteColore> variantiColori) {
        this.variantiColori = variantiColori;
    }

    @Override
    public String toString() {
        return "ListaColoriDto{" + "variantiColori=" + variantiColori + '}';
    }
    
    
}
