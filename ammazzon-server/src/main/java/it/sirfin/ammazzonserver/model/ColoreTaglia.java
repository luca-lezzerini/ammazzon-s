package it.sirfin.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ColoreTaglia implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer giacenza;

    @JsonIgnoreProperties(value = "coloreTaglia")
    @OneToMany(mappedBy = "coloreTaglia")
    private List<QtaOrdineVariante> qtaOrdiniVarianti;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private ProdottoColore prodottoColore;

    public ColoreTaglia() {
    }

    public ColoreTaglia(Integer giacenza, List<QtaOrdineVariante> qtaOrdiniVarianti, ProdottoColore prodottoColore) {
        this.giacenza = giacenza;
        this.qtaOrdiniVarianti = qtaOrdiniVarianti;
        this.prodottoColore = prodottoColore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(Integer giacenza) {
        this.giacenza = giacenza;
    }

    public List<QtaOrdineVariante> getQtaOrdiniVarianti() {
        return qtaOrdiniVarianti;
    }

    public void setQtaOrdiniVarianti(List<QtaOrdineVariante> qtaOrdiniVarianti) {
        this.qtaOrdiniVarianti = qtaOrdiniVarianti;
    }

    public ProdottoColore getProdottoColore() {
        return prodottoColore;
    }

    public void setProdottoColore(ProdottoColore prodottoColore) {
        this.prodottoColore = prodottoColore;
    }

    @Override
    public String toString() {
        return "ColoreTaglia{" + "id=" + id + ", giacenza=" + giacenza + ", qtaOrdiniVarianti=" + qtaOrdiniVarianti.size() + ", prodottoColore=" + prodottoColore.getId() + '}';
    }
    
    

}
