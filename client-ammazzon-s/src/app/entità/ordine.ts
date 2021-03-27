import { QtaOrdineVariante } from "./qnt-ordine-variante";
import { UtenteRegistrato } from "./utente-registrato";

export class Ordine {

    id: bigint;

    data = new Date();

    numero: number;

    stato: string;

    utenteRegistrato = new UtenteRegistrato();

    qtaOrdiniVarianti: QtaOrdineVariante[] = [];
}