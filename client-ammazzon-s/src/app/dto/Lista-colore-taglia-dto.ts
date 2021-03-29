import { ColoreTaglia } from "../entità/colore-taglia";
import { VarianteTaglia } from "../entità/variante-taglia";

export class ListaColoreTagliaDto{
    coloriTaglie: ColoreTaglia[] = [];
    notColoriTaglie: VarianteTaglia[] = [];
}