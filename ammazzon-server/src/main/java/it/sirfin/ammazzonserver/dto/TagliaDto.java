package it.sirfin.ammazzonserver.dto;

import it.sirfin.ammazzonserver.model.VarianteTaglia;

public class TagliaDto {

    private VarianteTaglia varianteTaglia;

    public TagliaDto() {
    }

    public TagliaDto(VarianteTaglia varianteTaglia) {
        this.varianteTaglia = varianteTaglia;
    }

    public VarianteTaglia getVarianteTaglia() {
        return varianteTaglia;
    }

    public void setVarianteTaglia(VarianteTaglia varianteTaglia) {
        this.varianteTaglia = varianteTaglia;
    }

    @Override
    public String toString() {
        return "TagliaDto{" + "varianteTaglia=" + varianteTaglia + '}';
    }

}
