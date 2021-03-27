import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ColoreDto } from '../dto/colore-dto';
import { ListaColoriDto } from '../dto/lista-colori-dto';
import { RicercaColoreDto } from '../dto/ricerca-colore-dto';
import { VarianteColore } from '../entità/variante-colore';

@Component({
  selector: 'app-anagrafica-colori-galli',
  templateUrl: './anagrafica-colori-galli.component.html',
  styleUrls: ['./anagrafica-colori-galli.component.css', '../theme.css']
})
export class AnagraficaColoriGalliComponent implements OnInit, Automabile {

  automa: Automa;


  varianteColore = new VarianteColore();
  variantiColori: VarianteColore[] = [];
  inputRicerca = "";
  errore = "";
  url = "http://localhost:8080/";

  //Variabili di visualizzazione
  form: boolean;
  aggiungi: boolean;
  remove: boolean;
  edit: boolean;
  conf: boolean;
  annull: boolean;
  search: boolean;
  tabella: boolean;
  codiceInput: boolean;
  descrizione: boolean;

  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
    this.aggiorna();
  }

  ngOnInit(): void {
  }

  nuova() {
    this.automa.next(new AddEvent(), this.automa);
  }
  rimuovi() {
    this.automa.next(new RimuoviEvent(), this.automa);
  }
  modifica() {
    this.automa.next(new ModificaEvent(), this.automa);

  }
  conferma() {
    this.automa.next(new ConfermaEvent(), this.automa);
  }

  annulla() {
    this.automa.next(new AnnullaEvent(), this.automa);

  }
  seleziona(vc: VarianteColore) {
    this.varianteColore = vc;
    this.automa.next(new SelezionaEvent(), this.automa);
  }


  cerca() {
    this.automa.next(new RicercaEvent(), this.automa);
  }


  aggiorna() {
    this.http.get<ListaColoriDto>(this.url + "aggiorna-colore")
      .subscribe(r => this.variantiColori = r.variantiColori);
  }

  entraStatoRicerca() {
    this.remove = false;
    this.edit = false;
    this.conf = false;
    this.annull = false;
    this.form = false;
    this.aggiungi = true;
    this.search = true;
    this.tabella = true;
    this.codiceInput = false;
    this.descrizione = false;

  }
  entraStatoAggiungi() {
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.form = true;
    this.aggiungi = false;
    this.search = false;
    this.tabella = false;
    this.codiceInput = false;
    this.descrizione = false;

  }
  entraStatoVisualizza() {
    this.remove = true;
    this.edit = true;
    this.conf = false;
    this.annull = false;
    this.form = true;
    this.aggiungi = true;
    this.search = true;
    this.tabella = true;
    this.codiceInput = true;
    this.descrizione = true;
  }
  entraStatoModifica() {
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.form = true;
    this.aggiungi = false;
    this.search = false;
    this.tabella = false;
    this.codiceInput = false;
    this.descrizione = false;
  }
  entraStatoRimuovi() {
    this.remove = false;
    this.edit = false;
    this.conf = true;
    this.annull = true;
    this.form = true;
    this.aggiungi = false;
    this.search = false;
    this.tabella = false;
    this.codiceInput = true;
    this.descrizione = true;
  }
  salvaDati() {
    let dto = new ColoreDto();
    dto.varianteColore = this.varianteColore;
    if (this.varianteColore.codice && this.varianteColore.descrizione == null) {
      this.errore = "Errore! Devi inserire un colore PORCA ZOZZA";
    } else {
      this.errore = "";
      this.http.post<ListaColoriDto>(this.url + "aggiungi-colore", dto)
        .subscribe(r => {
          this.variantiColori = r.variantiColori;
          this.varianteColore = new VarianteColore();
          console.log("Abbiamo aggiunto un colore stupendo");
        });
    }
  }
  modificaDati() {
    let dto = new ColoreDto();
    dto.varianteColore = this.varianteColore;
    this.http.post<ListaColoriDto>(this.url + "modifica-colore", dto)
      .subscribe(r => {
        this.variantiColori = r.variantiColori;
      });
  }
  eliminaDati() {
    let dto = new ColoreDto();
    dto.varianteColore = this.varianteColore;
    this.http.post<ListaColoriDto>(this.url + "rimuovi-colore", dto)
      .subscribe(r => {
        this.variantiColori = r.variantiColori;
      });
  }
  aggiornaRisultatiRicerca() {
    let stringa = new RicercaColoreDto();
    stringa.criterioRicerca = this.inputRicerca;
    if (this.inputRicerca == "") {
      this.errore = "ERRORE! DEVI INSERIRE UN CRITERIO DI RICERCA PORCA ZZOZZA ";
    } else {
      this.errore = "";
      this.http.post<ListaColoriDto>(this.url + "ricerca-colore", stringa)
        .subscribe(r => {
          this.variantiColori = r.variantiColori;
          this.inputRicerca = "";

        });
    }
  }



}
