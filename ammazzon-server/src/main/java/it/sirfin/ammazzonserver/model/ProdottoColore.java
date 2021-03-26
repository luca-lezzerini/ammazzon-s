package it.sirfin.ammazzonserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProdottoColore implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnoreProperties(value="prodottoColore")
    @OneToMany(mappedBy = "prodottoColore")
    private List<ColoreTaglia> coloriTaglie;
}
