import { Prodotto } from "../entità/prodotto";

export class PaginaCompletaDto {
    pageNum: number;
    totalPages: number;
    prodotti: Prodotto[] = [];
}