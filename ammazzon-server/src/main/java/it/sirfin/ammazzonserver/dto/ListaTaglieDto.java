package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.VarianteTaglia;
import java.util.List;

public class ListaTaglieDto {

    private List<VarianteTaglia> listaTaglie;
    private Integer pageNum;
    private Integer totalPages;
    

    public ListaTaglieDto() {
    }

    public ListaTaglieDto(List<VarianteTaglia> listaTaglie, Integer pageNum, Integer totalPages) {
        this.listaTaglie = listaTaglie;
        this.pageNum = pageNum;
        this.totalPages = totalPages;
    }

    public List<VarianteTaglia> getListaTaglie() {
        return listaTaglie;
    }

    public void setListaTaglie(List<VarianteTaglia> listaTaglie) {
        this.listaTaglie = listaTaglie;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "ListaTaglieDto{" + "listaTaglie=" + listaTaglie + ", pageNum=" + pageNum + ", totalPages=" + totalPages + '}';
    }

    
}
