package it.sirfin.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VarianteColore implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codice;

    @Column
    private String descrizione;

    @OneToMany(mappedBy = "varianteColore")
    @JsonIgnoreProperties(value = "varianteColore")
    private List<ProdottoColore> prodottiColori;

    public VarianteColore() {
    }

    public VarianteColore(String codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
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

}
