import { ColoreTaglia } from "./colore-taglia";
import { Prodotto } from "./prodotto";
import { VarianteColore } from "./variante-colore";

export class ProdottoColore {
    id: bigint;
    coloriTaglie: ColoreTaglia[] = [];
    varianteColore = new VarianteColore();
    prodotto = new Prodotto();
}