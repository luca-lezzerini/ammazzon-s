import { VarianteTaglia } from "../entità/variante-taglia";


export class TagliaDto {
    varianteTaglia = new VarianteTaglia();
    pageNum: number;
    totalPages: number;
}