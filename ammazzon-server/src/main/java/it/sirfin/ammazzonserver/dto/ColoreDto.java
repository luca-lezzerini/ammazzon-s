/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.VarianteColore;

public class ColoreDto {

    private VarianteColore varianteColore;

    public ColoreDto() {
    }

    public ColoreDto(VarianteColore varianteColore) {
        this.varianteColore = varianteColore;
    }

    public VarianteColore getVarianteColore() {
        return varianteColore;
    }

    public void setVarianteColore(VarianteColore varianteColore) {
        this.varianteColore = varianteColore;
    }

    @Override
    public String toString() {
        return "ColoreDto{" + "varianteColore=" + varianteColore + '}';
    }

   
}
