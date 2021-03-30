
package it.sirfin.ammazzonserver.dto;

public class RicercaProdottoDto {
    
    private String criterioRicerca;

    public RicercaProdottoDto() {
    }

    public RicercaProdottoDto(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    public String getCriterioRicerca() {
        return criterioRicerca;
    }

    public void setCriterioRicerca(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    @Override
    public String toString() {
        return "RicercaProdottoDto{" + "criterioRicerca=" + criterioRicerca + '}';
    }
    
    
}
