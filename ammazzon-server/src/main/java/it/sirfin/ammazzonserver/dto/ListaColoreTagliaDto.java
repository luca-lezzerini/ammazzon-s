package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.ColoreTaglia;
import it.sirfin.ammazzonserver.model.VarianteTaglia;
import java.util.List;


public class ListaColoreTagliaDto {
    private List<ColoreTaglia> coloriTaglie;
    private List<VarianteTaglia> notColoriTaglie;

    public ListaColoreTagliaDto() {
    }

    public ListaColoreTagliaDto(List<ColoreTaglia> coloriTaglie, List<VarianteTaglia> notColoriTaglie) {
        this.coloriTaglie = coloriTaglie;
        this.notColoriTaglie = notColoriTaglie;
    }

    public List<ColoreTaglia> getColoriTaglie() {
        return coloriTaglie;
    }

    public void setColoriTaglie(List<ColoreTaglia> coloriTaglie) {
        this.coloriTaglie = coloriTaglie;
    }

    public List<VarianteTaglia> getNotColoriTaglie() {
        return notColoriTaglie;
    }

    public void setNotColoriTaglie(List<VarianteTaglia> notColoriTaglie) {
        this.notColoriTaglie = notColoriTaglie;
    }

    @Override
    public String toString() {
        return "ListaColoreTagliaDto{" + "coloriTaglie=" + coloriTaglie + ", notColoriTaglie=" + notColoriTaglie + '}';
    }

    
    
}