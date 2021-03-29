import { ProdottoColore } from "../entità/prodotto-colore";
import { VarianteTaglia } from "../entità/variante-taglia";

export class AssociaTagliaRequestDto{
    pc = new ProdottoColore();
    vt = new VarianteTaglia();
}