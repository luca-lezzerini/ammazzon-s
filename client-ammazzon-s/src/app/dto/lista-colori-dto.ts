import { ProdottoColore } from "../entità/prodotto-colore";
import { VarianteColore } from "../entità/variante-colore";

export class ListaColoriDto {
    listaPagine: VarianteColore[] = [];
    pageNum: number;
    totalPages: number;
}