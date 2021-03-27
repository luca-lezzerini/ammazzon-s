import { ProdottoColore } from "./prodotto-colore";

export class Prodotto {

    id: bigint;

    codice = "";

    descrizione = "";

    prezzo : number;

    prodottiColori: ProdottoColore[] = [];
}