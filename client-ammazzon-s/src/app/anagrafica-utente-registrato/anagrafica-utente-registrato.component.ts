import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { ModificaEvent, ConfermaEvent, AnnullaEvent, RimuoviEvent, AddEvent, RicercaEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ListaUtentiRegistratiDto } from '../dto/lista-utenti-registrati-dto';
import { RicercaUtenteDto } from '../dto/ricerca-utente-dto';
import { UtenteRegistratoDto } from '../dto/utente-registrato-dto';
import { UtenteRegistrato } from '../entità/utente-registrato';

@Component({
  selector: 'app-anagrafica-utente-registrato',
  templateUrl: './anagrafica-utente-registrato.component.html',
  styleUrls: ['./anagrafica-utente-registrato.component.css', '../theme.css']
})
export class AnagraficaUtenteRegistratoComponent implements OnInit, Automabile {

  automa: Automa;

  utente = new UtenteRegistrato();
  listaUtenti: UtenteRegistrato[] = [];

  form: boolean;
  aggiungi: boolean;
  remove: boolean;
  edit: boolean;
  conf: boolean = true;
  annull: boolean = true;
  search: boolean;
  tabella: boolean;
  codiceC: boolean;
  inputRicerca: string;
  errore = "";

  constructor(private http: HttpClient) {
    this.automa = new Automa(this);
    this.aggiorna();
  }
  ngOnInit(): void {
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
    let dto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utente;
    this.http.post<ListaUtentiRegistratiDto>("http://localhost:8080/aggiungi-utente", dto)
      .subscribe(r => {
        this.listaUtenti = r.listaUtentiRegistrati;
        this.utente = new UtenteRegistrato();
      });
  }

  modificaDati() {
    let dto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utente;
    this.http.post<ListaUtentiRegistratiDto>("http://localhost:8080/conferma-utente", dto)
      .subscribe(r => {
        this.listaUtenti = r.listaUtentiRegistrati;
      });
  }

  eliminaDati() {
    let dto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utente;
    this.http.post<ListaUtentiRegistratiDto>("http://localhost:8080/rimuovi-utente", dto)
      .subscribe(r => {
        this.listaUtenti = r.listaUtentiRegistrati;
      });
  }

  aggiornaRisultatiRicerca() {
    let dto = new RicercaUtenteDto();
    dto.criterioRicerca = this.inputRicerca;
    if (this.inputRicerca == null) {
      this.errore = "Inserisci il criterio di ricerca";
    } else {
      this.errore = "";
      this.http.post<ListaUtentiRegistratiDto>("http://localhost:8080/ricerca-utente", dto)
        .subscribe(r => {
          this.listaUtenti = r.listaUtentiRegistrati;
        });
    }
  }

  ritornaTaglia(l: UtenteRegistrato) {
    let dto = new UtenteRegistratoDto();
    dto.utenteRegistrato = l;
    this.http.post<UtenteRegistratoDto>("http://localhost:8080/rit-utente", dto)
      .subscribe(r => {
        this.utente = r.utenteRegistrato;
      });
  }

  aggiorna() {
    this.http.get<ListaUtentiRegistratiDto>("http://localhost:8080/aggiorna-utente")
      .subscribe(r => this.listaUtenti = r.listaUtentiRegistrati);
  }



  modifica() {
    this.automa.next(new ModificaEvent(), this.automa);
  }

  conferma() {
    this.automa.next(new ConfermaEvent(), this.automa);
  }

  annulla() {
    this.utente = new UtenteRegistrato();
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

  seleziona(l: UtenteRegistrato) {
    this.ritornaTaglia(l);
    this.automa.next(new SelezionaEvent(), this.automa);
  }

}
