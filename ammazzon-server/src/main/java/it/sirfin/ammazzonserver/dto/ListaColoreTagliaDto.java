package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.ColoreTaglia;
import java.util.List;


public class ListaColoreTagliaDto {
    private List<ColoreTaglia> coloriTaglie;

    public ListaColoreTagliaDto() {
    }

    public ListaColoreTagliaDto(List<ColoreTaglia> coloriTaglie) {
        this.coloriTaglie = coloriTaglie;
    }

    public List<ColoreTaglia> getColoriTaglie() {
        return coloriTaglie;
    }

    public void setColoriTaglie(List<ColoreTaglia> coloriTaglie) {
        this.coloriTaglie = coloriTaglie;
    }

    @Override
    public String toString() {
        return "ListaColoreTagliaDto{" + "coloriTaglie=" + coloriTaglie + '}';
    }
}
