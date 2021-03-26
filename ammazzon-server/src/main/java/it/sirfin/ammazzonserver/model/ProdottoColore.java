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

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private VarianteColore varianteColore;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Prodotto prodotto;

    public ProdottoColore() {
    }

    public ProdottoColore(VarianteColore varianteColore, Prodotto prodotto) {
        this.coloriTaglie = coloriTaglie;
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
        return varianteColore;
    }

    public void setVarianteColore(VarianteColore varianteColore) {
        this.varianteColore = varianteColore;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public String toString() {
        return "ProdottoColore{" + "id=" + id + ", coloriTaglie=" + coloriTaglie.size() + ", varianteColore=" + varianteColore.getId() + ", prodotto=" + prodotto.getId() + '}';
    }

}
