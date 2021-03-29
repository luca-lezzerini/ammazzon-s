package it.sirfin.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProdottoColore implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnoreProperties(value = "prodottoColore")
    @OneToMany(mappedBy = "prodottoColore")
    private List<ColoreTaglia> coloriTaglie;

    @JsonIgnoreProperties(value = "prodottiColori")
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private VarianteColore varianteColore;

    @JsonIgnoreProperties(value = "prodottiColori")
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Prodotto prodotto;

    public ProdottoColore() {
    }

    public ProdottoColore(VarianteColore varianteColore, Prodotto prodotto) {
        this.varianteColore = varianteColore;
        this.prodotto = prodotto;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ColoreTaglia> getColoriTaglie() {
        if (coloriTaglie == null) {
            coloriTaglie = new ArrayList<>();
        }
        return coloriTaglie;
    }

    public void setColoriTaglie(List<ColoreTaglia> coloriTaglie) {
        if (coloriTaglie == null) {
            coloriTaglie = new ArrayList<>();
        }
        this.coloriTaglie = coloriTaglie;
    }

    public VarianteColore getVarianteColore() {     
        if (varianteColore == null) {
            varianteColore = new VarianteColore();
        }
        return varianteColore;
    }

    public void setVarianteColore(VarianteColore varianteColore) {
        if (varianteColore == null) {
            varianteColore = new VarianteColore();
        }
        this.varianteColore = varianteColore;
    }

    public Prodotto getProdotto() {
        if (prodotto == null) {
            prodotto = new Prodotto();
        }
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        if (prodotto == null) {
            prodotto = new Prodotto();
        }
        this.prodotto = prodotto;
    }

    @Override
    public String toString() {
        return "ProdottoColore{" + "id=" + id + ", coloriTaglie=" + coloriTaglie + ", varianteColore=" + varianteColore + ", prodotto=" + prodotto + '}';
    }
    
}
