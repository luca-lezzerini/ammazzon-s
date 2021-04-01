package it.sirfin.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prodotto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 40)
    private String codice;

    @Column
    private String descrizione;

    @Column
    private Double prezzo;

    @JsonIgnoreProperties(value = "prodotto")
    @OneToMany(mappedBy = "prodotto")
    private List<ProdottoColore> prodottiColori;

    public Prodotto() {
    }

    public Prodotto(String codice, String descrizione, Double prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public List<ProdottoColore> getProdottiColori() {
        if (prodottiColori == null) {
            prodottiColori = new ArrayList<>();
        }
        return prodottiColori;
    }

    public void setProdottiColori(List<ProdottoColore> prodottiColori) {
        if (prodottiColori == null) {
            prodottiColori = new ArrayList<>();
        }
        this.prodottiColori = prodottiColori;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", prodottiColori=" + prodottiColori.size() + '}';
    }

}
