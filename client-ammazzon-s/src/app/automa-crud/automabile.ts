import { PaginaDto } from "../app-paginate/pagina-dto";

export interface Automabile{

    entraStatoRicerca();
    entraStatoAggiungi();
    entraStatoVisualizza();
    entraStatoModifica();
    entraStatoRimuovi();
    salvaDati();
    modificaDati();
    eliminaDati();
    aggiornaRisultatiRicerca();
}