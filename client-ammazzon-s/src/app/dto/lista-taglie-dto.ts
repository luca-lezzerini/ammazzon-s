import { VarianteTaglia } from "../entità/variante-taglia";


export class ListaTaglieDto {
    listaTaglie: VarianteTaglia[] = [];
    pageNum: number;
    totalPages: number;
}