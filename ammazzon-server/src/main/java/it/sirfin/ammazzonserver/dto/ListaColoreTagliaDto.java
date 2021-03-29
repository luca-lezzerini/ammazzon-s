package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.ColoreTaglia;
import java.util.List;


public class ListaColoreTagliaDto {
    private List<ColoreTaglia> coloriTaglie;
    private List<ColoreTaglia> notColoriTaglie;

    public ListaColoreTagliaDto() {
    }

    public ListaColoreTagliaDto(List<ColoreTaglia> coloriTaglie, List<ColoreTaglia> notColoriTaglie) {
        this.coloriTaglie = coloriTaglie;
        this.notColoriTaglie = notColoriTaglie;
    }

    public List<ColoreTaglia> getColoriTaglie() {
        return coloriTaglie;
    }

    public void setColoriTaglie(List<ColoreTaglia> coloriTaglie) {
        this.coloriTaglie = coloriTaglie;
    }

    public List<ColoreTaglia> getNotColoriTaglie() {
        return notColoriTaglie;
    }

    public void setNotColoriTaglie(List<ColoreTaglia> notColoriTaglie) {
        this.notColoriTaglie = notColoriTaglie;
    }

    @Override
    public String toString() {
        return "ListaColoreTagliaDto{" + "coloriTaglie=" + coloriTaglie + ", notColoriTaglie=" + notColoriTaglie + '}';
    }

    
}