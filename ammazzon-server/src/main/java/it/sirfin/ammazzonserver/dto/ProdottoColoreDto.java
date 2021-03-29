/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.ProdottoColore;

/**
 *
 * @author laptop
 */
public class ProdottoColoreDto {
    private ProdottoColore prodottoColore;

    public ProdottoColoreDto() {
    }

    public ProdottoColoreDto(ProdottoColore prodottoColore) {
        this.prodottoColore = prodottoColore;
    }

    public ProdottoColore getProdottoColore() {
        return prodottoColore;
    }

    public void setProdottoColore(ProdottoColore prodottoColore) {
        this.prodottoColore = prodottoColore;
    }

    @Override
    public String toString() {
        return "ProdottoColoreDto{" + "prodottoColore=" + prodottoColore + '}';
    }
    
    
}
