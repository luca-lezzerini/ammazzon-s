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
public class VarianteTaglia implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String codice;

    @JsonIgnoreProperties(value = "varianteTaglia")
    @OneToMany(mappedBy = "varianteTaglia")
    private List<ColoreTaglia> coloriTaglie;

    public VarianteTaglia() {
    }

    public VarianteTaglia(String codice, List<ColoreTaglia> coloriTaglie) {
        this.codice = codice;
        this.coloriTaglie = coloriTaglie;
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

    @Override
    public String toString() {
        return "VarianteTaglia{" + "id=" + id + ", codice=" + codice + ", coloriTaglie=" + coloriTaglie.size() + '}';
    }

}
