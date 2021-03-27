import { ColoreTaglia } from "./colore-taglia";
import { Ordine } from "./ordine";

export class QtaOrdineVariante {

    id: bigint;
    qta: number;
    ordine = new Ordine();
    coloreTaglia = new ColoreTaglia();
}