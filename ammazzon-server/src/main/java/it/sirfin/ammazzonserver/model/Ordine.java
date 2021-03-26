package it.sirfin.ammazzonserver.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
   private UtenteRegistrato utenteRegistrato;
    
}
