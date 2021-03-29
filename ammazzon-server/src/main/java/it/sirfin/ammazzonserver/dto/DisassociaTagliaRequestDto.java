package it.sirfin.ammazzonserver.dto;


public class DisassociaTagliaRequestDto {
    private Long idColoreTaglia;
    
    private Long idProdottoColore;

    public DisassociaTagliaRequestDto(Long idColoreTaglia, Long idProdottoColore) {
        this.idColoreTaglia = idColoreTaglia;
        this.idProdottoColore = idProdottoColore;
    }

    public DisassociaTagliaRequestDto() {
    }

    public Long getIdColoreTaglia() {
        return idColoreTaglia;
    }

    public void setIdColoreTaglia(Long idColoreTaglia) {
        this.idColoreTaglia = idColoreTaglia;
    }

    public Long getIdProdottoColore() {
        return idProdottoColore;
    }

    public void setIdProdottoColore(Long idProdottoColore) {
        this.idProdottoColore = idProdottoColore;
    }

    @Override
    public String toString() {
        return "DisassociaTagliaRequestDto{" + "idColoreTaglia=" + idColoreTaglia + ", idProdottoColore=" + idProdottoColore + '}';
    }
    
    
}
