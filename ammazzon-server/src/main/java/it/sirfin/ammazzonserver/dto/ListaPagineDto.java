/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.ammazzonserver.dto;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Admin
 */
public class ListaPagineDto<T> {

    private List<T> listaPagine;
    private Integer pageNum;
    private Integer totalPages;

    public ListaPagineDto() {
    }

    public ListaPagineDto(List<T> listaPagine, Integer pageNum, Integer totalPages) {
        this.listaPagine = listaPagine;
        this.pageNum = pageNum;
        this.totalPages = totalPages;
    }

    public List<T> getListaPagine() {
        return listaPagine;
    }

    public void setListaPagine(List<T> listaPagine) {
        this.listaPagine = listaPagine;
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

}
