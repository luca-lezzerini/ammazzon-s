package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.Prodotto;
import java.util.List;


public class PaginaCompletaDto {
    private int pageNum;
    private int totalPages;
    private List<Prodotto> prodotti;

    public PaginaCompletaDto() {
    }

    public PaginaCompletaDto(int pageNum, int totalPages, List<Prodotto> prodotti) {
        this.pageNum = pageNum;
        this.totalPages = totalPages;
        this.prodotti = prodotti;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    @Override
    public String toString() {
        return "PaginaDto{" + "pageNum=" + pageNum + ", totalPages=" + totalPages + ", prodotti=" + prodotti + '}';
    }

    
}
