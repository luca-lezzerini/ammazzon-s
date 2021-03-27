package it.sirfin.ammazzonserver.dto;


public class RicercaStringaReqDto {
    private String criterioRicerca;

    public RicercaStringaReqDto() {
    }

    public RicercaStringaReqDto(String criterioRicerca) {
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
        return "RicercaStringaReqDto{" + "criterioRicerca=" + criterioRicerca + '}';
    }
}
