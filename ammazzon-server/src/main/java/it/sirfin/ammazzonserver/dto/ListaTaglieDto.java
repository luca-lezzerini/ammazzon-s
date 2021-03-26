package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.VarianteTaglia;
import java.util.List;

public class ListaTaglieDto {

    private List<VarianteTaglia> listaTaglie;

    public ListaTaglieDto() {
    }

    public ListaTaglieDto(List<VarianteTaglia> listaTaglie) {
        this.listaTaglie = listaTaglie;
    }

    public List<VarianteTaglia> getListaTaglie() {
        return listaTaglie;
    }

    public void setListaTaglie(List<VarianteTaglia> listaTaglie) {
        this.listaTaglie = listaTaglie;
    }

    @Override
    public String toString() {
        return "ListaTaglieDto{" + "listaTaglie=" + listaTaglie + '}';
    }

}
