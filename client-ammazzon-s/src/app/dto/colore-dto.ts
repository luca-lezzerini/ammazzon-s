import { VarianteColore } from "../entità/variante-colore";

export class ColoreDto {
    varianteColore = new VarianteColore();
    pageNum: number;
    totalPages: number;
}