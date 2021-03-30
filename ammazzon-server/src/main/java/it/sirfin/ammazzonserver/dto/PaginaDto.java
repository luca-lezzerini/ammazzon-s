/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

public class PaginaDto {
    private Integer pageNum;
    private Integer totalPages;

    public PaginaDto() {
    }

    public PaginaDto(Integer pageNum, Integer totalPages) {
        this.pageNum = pageNum;
        this.totalPages = totalPages;
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
        return "PaginaDto{" + "pageNum=" + pageNum + ", totalPages=" + totalPages + '}';
    }
    
    
}
