package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.VarianteTaglia;

public class TagliaDto {

    private VarianteTaglia varianteTaglia;
    private Integer pageNum;
  

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


    public TagliaDto(VarianteTaglia varianteTaglia, Integer pageNum) {
        this.varianteTaglia = varianteTaglia;
        this.pageNum = pageNum;
    }

    public TagliaDto() {
    }

    @Override
    public String toString() {
        return "TagliaDto{" + "varianteTaglia=" + varianteTaglia + ", pageNum=" + pageNum +'}';
    }
    

}
