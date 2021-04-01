package it.sirfin.ammazzonserver.dto;

public class ChiediPaginaDto {
    private String criterioRicerca;
    private int numeroPagina;
    private int numeroRisultati;

    public ChiediPaginaDto() {
    }

    public ChiediPaginaDto(String criterioRicerca, int numeroPagina, int numeroRisultati) {
        this.criterioRicerca = criterioRicerca;
        this.numeroPagina = numeroPagina;
        this.numeroRisultati = numeroRisultati;
    }

    public int getNumeroRisultati() {
        return numeroRisultati;
    }

    public void setNumeroRisultati(int numeroRisultati) {
        this.numeroRisultati = numeroRisultati;
    }

    

    public String getCriterioRicerca() {
        return criterioRicerca;
    }

    public void setCriterioRicerca(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    @Override
    public String toString() {
        return "ChiediPaginaDto{" + "criterioRicerca=" + criterioRicerca + ", numeroPagina=" + numeroPagina + ", numeroRisultati=" + numeroRisultati + '}';
    }

   
    
    
}
