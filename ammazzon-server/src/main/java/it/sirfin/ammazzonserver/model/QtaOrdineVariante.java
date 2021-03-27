package it.sirfin.ammazzonserver.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QtaOrdineVariante implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer qta;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Ordine ordine;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ColoreTaglia coloreTaglia;

    public QtaOrdineVariante() {
    }

    public QtaOrdineVariante(Integer qta) {
        this.qta = qta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQta() {
        return qta;
    }

    public void setQta(Integer qta) {
        this.qta = qta;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public ColoreTaglia getColoreTaglia() {
        return coloreTaglia;
    }

    public void setColoreTaglia(ColoreTaglia coloreTaglia) {
        this.coloreTaglia = coloreTaglia;
    }

    @Override
    public String toString() {
        return "QtaOrdineVariante{" + "id=" + id + ", qta=" + qta + ", ordine=" + ordine.getId() + ", coloreTaglia=" + coloreTaglia.getId() + '}';
    }
    
    

}
