import { ProdottoColore } from "./prodotto-colore";
import { QtaOrdineVariante } from "./qnt-ordine-variante";
import { VarianteTaglia } from "./variante-taglia";

export class ColoreTaglia {

    id: bigint;
    giacenza: number;
    qtaOrdiniVarianti: QtaOrdineVariante[] = [];
    prodottoColore = new ProdottoColore();
    varianteTaglia = new VarianteTaglia();

}