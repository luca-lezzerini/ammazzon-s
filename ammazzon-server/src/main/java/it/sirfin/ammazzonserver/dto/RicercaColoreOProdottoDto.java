/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

/**
 *
 * @author Admin
 */
public class RicercaColoreOProdottoDto {

    private String criterioRicerca;
    private Integer pageNum;
    private Integer totalPages;

    public RicercaColoreOProdottoDto() {
    }

    public RicercaColoreOProdottoDto(String criterioRicerca, Integer pageNum, Integer totalPages) {
        this.criterioRicerca = criterioRicerca;
        this.pageNum = pageNum;
        this.totalPages = totalPages;
    }

    public String getCriterioRicerca() {
        return criterioRicerca;
    }

    public void setCriterioRicerca(String criterioRicerca) {
        this.criterioRicerca = criterioRicerca;
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
        return "RicercaColoreOProdottoDto{" + "criterioRicerca=" + criterioRicerca + ", pageNum=" + pageNum + ", totalPages=" + totalPages + '}';
    }
    
}
