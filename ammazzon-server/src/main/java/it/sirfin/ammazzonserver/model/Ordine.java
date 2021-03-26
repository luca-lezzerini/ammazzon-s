package it.sirfin.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ordine implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDate data;

    @Column
    private Integer numero;

    @Column
    private String stato = "CARRELLO";

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private UtenteRegistrato utenteRegistrato;

    @JsonIgnoreProperties(value = "ordine")
    @OneToMany(mappedBy = "ordine")
    private List<QtaOrdineVariante> qtaOrdiniVarianti;

    public Ordine() {
    }

    public Ordine(LocalDate data, Integer numero, UtenteRegistrato utenteRegistrato, List<QtaOrdineVariante> qtaOrdiniVarianti) {
        this.data = data;
        this.numero = numero;
        this.utenteRegistrato = utenteRegistrato;
        this.qtaOrdiniVarianti = qtaOrdiniVarianti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public UtenteRegistrato getUtenteRegistrato() {
        return utenteRegistrato;
    }

    public void setUtenteRegistrato(UtenteRegistrato utenteRegistrato) {
        this.utenteRegistrato = utenteRegistrato;
    }

    public List<QtaOrdineVariante> getQtaOrdiniVarianti() {
        if (qtaOrdiniVarianti == null) {
            qtaOrdiniVarianti = new ArrayList<>();
        }
        return qtaOrdiniVarianti;
    }

    public void setQtaOrdiniVarianti(List<QtaOrdineVariante> qtaOrdiniVarianti) {
        if (qtaOrdiniVarianti == null) {
            qtaOrdiniVarianti = new ArrayList<>();
        }
        this.qtaOrdiniVarianti = qtaOrdiniVarianti;
    }

    @Override
    public String toString() {
        return "Ordine{" + "id=" + id + ", data=" + data + ", numero=" + numero + ", stato=" + stato + ", nome utenteRegistrato=" + utenteRegistrato.getNome() + ", qtaOrdiniVarianti=" + qtaOrdiniVarianti.size() + '}';
    }

}
