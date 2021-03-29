/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.Prodotto;
import it.sirfin.ammazzonserver.model.VarianteColore;

/**
 *
 * @author feder
 */
public class ProdottoColoreDtoGal {
    private Prodotto prodotto;
    private VarianteColore colore;

    public ProdottoColoreDtoGal() {
    }
    

    public ProdottoColoreDtoGal(Prodotto prodotto, VarianteColore colore) {
        this.prodotto = prodotto;
        this.colore = colore;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public VarianteColore getColore() {
        return colore;
    }

    public void setColore(VarianteColore colore) {
        this.colore = colore;
    }

    @Override
    public String toString() {
        return "ProdottoColoreGal{" + "prodotto=" + prodotto + ", colore=" + colore + '}';
    }
    
    
}
