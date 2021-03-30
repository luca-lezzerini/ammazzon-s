import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ListaTaglieDto } from '../dto/lista-taglie-dto';
import { RicercaTaglieDto } from '../dto/ricerca-taglie-dto';
import { TagliaDto } from '../dto/taglia-dto';
import { VarianteTaglia } from '../entità/variante-taglia';

@Component({
  selector: 'app-anagrafica-taglia',
  templateUrl: './anagrafica-taglia.component.html',
  styleUrls: ['./anagrafica-taglia.component.css', '../theme.css']
})
export class AnagraficaTagliaComponent implements OnInit, Automabile {

  automa: Automa;
  inputRicerca: string;
  taglia = new VarianteTaglia();
  listaTaglie: VarianteTaglia[] = [];
  errore = "";
  paginaCorrente = 1;
  numeroPagine = 10;

  form: boolean;
  aggiungi: boolean;
  remove: boolean;
  edit: boolean;
  conf: boolean = true;
  annull: boolean = true;
  search: boolean;
  tabella: boolean;
  codiceC: boolean;

  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
    this.aggiorna();
  }

  ngOnInit(): void {
  }

  primo(event) {
    console.log(event);
  }
  successivo(event) {
    console.log(event);
  }
  numero(event) {
    console.log(event);
  }
  precedente(event) {
    console.log(event);
  }
  ultimo(event) {
    console.log(event);
  }

  entraStatoRicerca() {
    this.form = false;
    this.aggiungi = true;
    this.search = true;
    this.tabella = true;
    this.codiceC = false;
    this.remove = false;
    this.edit = false;
    this.conf = false;
    this.annull = false;
  }
  entraStatoAggiungi() {
    this.form = true;
    this.aggiungi = false;
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.search = false;
    this.tabella = false;
    this.codiceC = false;
  }
  entraStatoVisualizza() {
    this.form = true;
    this.aggiungi = true;
    this.remove = true;
    this.edit = true;
    this.conf = false;
    this.annull = false;
    this.search = true;
    this.tabella = true;
    this.codiceC = true;
  }
  entraStatoModifica() {
    this.form = true;
    this.aggiungi = false;
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.search = false;
    this.tabella = false;
    this.codiceC = false;
  }
  entraStatoRimuovi() {
    this.form = true;
    this.aggiungi = false;
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.search = false;
    this.tabella = false;
    this.codiceC = true;
  }

  salvaDati() {
    let dto = new TagliaDto();
    dto.varianteTaglia = this.taglia;
    this.http.post<ListaTaglieDto>("http://localhost:8080/aggiungi-taglia", dto)
      .subscribe(r => {
        this.listaTaglie = r.listaTaglie;
        this.taglia = new VarianteTaglia();
      });
  }

  modificaDati() {
    let dto = new TagliaDto();
    dto.varianteTaglia = this.taglia;
    this.http.post<ListaTaglieDto>("http://localhost:8080/conferma-taglia", dto)
      .subscribe(r => {
        this.listaTaglie = r.listaTaglie;
      });
  }

  eliminaDati() {
    let dto = new TagliaDto();
    dto.varianteTaglia = this.taglia;
    this.http.post<ListaTaglieDto>("http://localhost:8080/rimuovi-taglia", dto)
      .subscribe(r => {
        this.listaTaglie = r.listaTaglie;
      });
  }

  aggiornaRisultatiRicerca() {
    let dto = new RicercaTaglieDto();
    dto.criterioRicerca = this.inputRicerca;
    if (this.inputRicerca == null) {
      this.errore = "Inserisci il criterio di ricerca";
    } else {
      this.errore = "";
      this.http.post<ListaTaglieDto>("http://localhost:8080/ricerca-taglia", dto)
        .subscribe(r => {
          this.listaTaglie = r.listaTaglie;
        });
    }
  }

  ritornaTaglia(l: VarianteTaglia) {
    let dto = new TagliaDto();
    dto.varianteTaglia = l;
    this.http.post<TagliaDto>("http://localhost:8080/rit-taglia", dto)
      .subscribe(r => {
        this.taglia = r.varianteTaglia;
      });
  }

  aggiorna() {
    this.http.get<ListaTaglieDto>("http://localhost:8080/aggiorna-taglia")
      .subscribe(r => this.listaTaglie = r.listaTaglie);
  }

  modifica() {
    this.automa.next(new ModificaEvent(), this.automa);
  }

  conferma() {
    this.automa.next(new ConfermaEvent(), this.automa);
  }

  annulla() {
    this.taglia = new VarianteTaglia();
    this.automa.next(new AnnullaEvent(), this.automa);
  }

  rimuovi() {
    this.automa.next(new RimuoviEvent(), this.automa);
  }

  nuova() {
    this.automa.next(new AddEvent(), this.automa);
  }

  cerca() {
    this.automa.next(new RicercaEvent(), this.automa);
  }

  seleziona(l: VarianteTaglia) {
    this.ritornaTaglia(l);
    this.automa.next(new SelezionaEvent(), this.automa);
  }
}
