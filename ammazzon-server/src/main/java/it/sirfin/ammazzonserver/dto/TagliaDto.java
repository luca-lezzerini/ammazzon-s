package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.VarianteTaglia;

public class TagliaDto {

    private VarianteTaglia varianteTaglia;
    private Integer pageNum;
    private Integer totalPages;
    
    

    public VarianteTaglia getVarianteTaglia() {
        return varianteTaglia;
    }

    public void setVarianteTaglia(VarianteTaglia varianteTaglia) {
        this.varianteTaglia = varianteTaglia;
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

    public TagliaDto(VarianteTaglia varianteTaglia, Integer pageNum, Integer totalPages) {
        this.varianteTaglia = varianteTaglia;
        this.pageNum = pageNum;
        this.totalPages = totalPages;
    }

    public TagliaDto() {
    }

    @Override
    public String toString() {
        return "TagliaDto{" + "varianteTaglia=" + varianteTaglia + ", pageNum=" + pageNum + ", totalPages=" + totalPages + '}';
    }
    

}
