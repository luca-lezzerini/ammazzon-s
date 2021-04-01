import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { PaginaDto } from '../app-paginate/pagina-dto';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { ModificaEvent, ConfermaEvent, AnnullaEvent, RimuoviEvent, AddEvent, RicercaEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ListaPagineDto } from '../dto/lista-pagine-dto';
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
  listaUtenti: ListaPagineDto[] = [];
  paginaDto = new PaginaDto();
  paginaCorrente: number = 1; //da sistemare (bisogna recuperare il num dall'input)
  numeroPagine: number = 12;
  prova = "";
  listaUtentiPag: UtenteRegistrato[] = [];
  

  @Input() pagina: number;
  @Input() totali: number;

  @Output() primo: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() precedente: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() numero: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() successivo: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() ultimo: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();

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
    this.http.post<ListaPagineDto>("http://localhost:8080/aggiungi-utente", dto)
      .subscribe(r => {
        this.listaUtenti = r.listaPagine;
        this.utente = new UtenteRegistrato();
      });
  }

  modificaDati() {
    let dto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utente;
    this.http.post<ListaPagineDto>("http://localhost:8080/conferma-utente", dto)
      .subscribe(r => {
        this.listaUtenti = r.listaPagine;
      });
  }

  eliminaDati() {
    let dto = new UtenteRegistratoDto();
    dto.utenteRegistrato = this.utente;
    this.http.post<ListaPagineDto>("http://localhost:8080/rimuovi-utente", dto)
      .subscribe(r => {
        this.listaUtenti = r.listaPagine;
      });
  }

  aggiornaRisultatiRicerca() {
    let dto = new RicercaUtenteDto();
    dto.criterioRicerca = this.inputRicerca;
    if (this.inputRicerca == null) {
      this.errore = "Inserisci il criterio di ricerca";
    } else {
      this.errore = "";
      this.http.post<ListaPagineDto>("http://localhost:8080/ricerca-utente", dto)
        .subscribe(r => {
          this.listaUtenti = r.listaPagine;
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
    this.http.get<ListaPagineDto>("http://localhost:8080/aggiorna-utente")
      .subscribe(r => this.listaUtenti = r.listaPagine);
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
  //-------------------------------------------
  //metodi del paginate

  primoE(event: PaginaDto) {
    console.log(event);
    console.log(event);
    let PagDto = new ListaPagineDto();
    PagDto.pageNum = this.paginaCorrente; //forzatura per le prove (fino a che non si sitema l'acquisizione di paginaCorrente)
    PagDto.totalPages = this.numeroPagine;
    this.http.post<ListaPagineDto>("http://localhost:8080/aggiorna-tabella", PagDto)
      .subscribe(r => this.listaUtenti = r.listaPagine);
      this.paginaCorrente = event.pageNum;
      console.log(event.pageNum);
  }
  successivoE(event: PaginaDto) {
    console.log(event);
    let PagDto = new ListaPagineDto();
    PagDto.pageNum = this.paginaCorrente + 1; //incremento forzato per le prove (fino a che non si sitema l'acquisizione di paginaCorrente)
    PagDto.totalPages = this.numeroPagine;
    this.http.post<ListaPagineDto>("http://localhost:8080/aggiorna-tabella", PagDto)
      .subscribe(r => this.listaUtenti = r.listaPagine);
      this.paginaCorrente = event.pageNum;
      console.log(event.pageNum);
  }
  numeroE(event: PaginaDto) {
    console.log(event);
    this.paginaCorrente = event.pageNum;
    console.log(event.pageNum);
  }
  precedenteE(event: PaginaDto) {
    console.log(event);
    console.log(event);
    let PagDto = new ListaPagineDto();
    PagDto.pageNum = this.paginaCorrente - 1; //decremento forzato per le prove (fino a che non si sitema l'acquisizione di paginaCorrente)
    PagDto.totalPages = this.numeroPagine;
    this.http.post<ListaPagineDto>("http://localhost:8080/aggiorna-tabella", PagDto)
      .subscribe(r => this.listaUtenti = r.listaPagine);
      this.paginaCorrente = event.pageNum;
      console.log(event.pageNum);
  }
  ultimoE(event: PaginaDto) {
    console.log(event);
    this.paginaCorrente = event.pageNum;
    console.log(event.pageNum);
    
  }

}
