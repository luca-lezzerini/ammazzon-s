package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.ProdottoColore;
import it.sirfin.ammazzonserver.model.VarianteTaglia;


public class AssociaTagliaRequestDto {
    private ProdottoColore pc; 
    private VarianteTaglia vt;

    public AssociaTagliaRequestDto() {
    }

    public AssociaTagliaRequestDto(ProdottoColore pc, VarianteTaglia vt) {
        this.pc = pc;
        this.vt = vt;
    }

    public ProdottoColore getPc() {
        return pc;
    }

    public void setPc(ProdottoColore pc) {
        this.pc = pc;
    }

    public VarianteTaglia getVt() {
        return vt;
    }

    public void setVt(VarianteTaglia vt) {
        this.vt = vt;
    }

    @Override
    public String toString() {
        return "AssociaTagliaRequestDto{" + "pc=" + pc.getId() + ", vt=" + vt.getId() + '}';
    }
    
    
}
