import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { PaginaDto } from '../app-paginate/pagina-dto';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { ModificaEvent, ConfermaEvent, AnnullaEvent, RimuoviEvent, AddEvent, RicercaEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ChiediPaginaDto } from '../dto/chiedi-pagina-dto';
import { ListaPagineDto } from '../dto/lista-pagine-dto';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { PaginaCompletaDto } from '../dto/pagina-completa-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { RicercaProdottoDto } from '../dto/ricerca-prodotto-dto';
import { Prodotto } from '../entità/prodotto';
import { UtenteRegistrato } from '../entità/utente-registrato';

@Component({
  selector: 'app-anagrafica-prodotto',
  templateUrl: './anagrafica-prodotto.component.html',
  styleUrls: ['./anagrafica-prodotto.component.css']
})
export class AnagraficaProdottoComponent implements OnInit, Automabile {

  automa: Automa;

  prodotto = new Prodotto();
  listaProdotti: Prodotto[] = [];

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

  paginaCorrente = 1;
  numeroPagine: number;

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
    let dto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    console.log(dto);
    this.http.post<ListaProdottiDto>("http://localhost:8080/aggiungi-prodotto", dto)
      .subscribe(r => {
        this.listaProdotti = r.listaProdotti;
        this.prodotto = new Prodotto();
      });
  }

  modificaDati() {
    let dto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    this.http.post<ListaProdottiDto>("http://localhost:8080/conferma-prodotto", dto)
      .subscribe(r => {
        this.listaProdotti = r.listaProdotti;
      });
  }

  eliminaDati() {
    let dto = new ProdottoDto();
    dto.prodotto = this.prodotto;
    this.http.post<ListaProdottiDto>("http://localhost:8080/rimuovi-prodotto", dto)
      .subscribe(r => {
        this.listaProdotti = r.listaProdotti;
      });
  }

  aggiornaRisultatiRicerca() {
    let dto = new RicercaProdottoDto();
    dto.criterioRicerca = this.inputRicerca;
    if (this.inputRicerca == null) {
      this.errore = "Inserisci il criterio di ricerca";
    } else {
      this.errore = "";
      this.http.post<ListaProdottiDto>("http://localhost:8080/ricerca-prodotto", dto)
        .subscribe(r => {
          this.listaProdotti = r.listaProdotti;
        });
    }
  }

  selezionaProdotto(p: Prodotto) {
    let dto = new ProdottoDto();
    dto.prodotto = p;
    this.http.post<ProdottoDto>("http://localhost:8080/seleziona-prodotti", dto)
      .subscribe(r => {
        this.prodotto = r.prodotto;
      });
  }

  aggiorna() {
    let paginaCompletaDto = new PaginaCompletaDto();
    paginaCompletaDto.pageNum = this.paginaCorrente;
    paginaCompletaDto.totalPages = this.numeroPagine;
    this.http.post<ListaProdottiDto>("http://localhost:8080/aggiorna-prodotti", paginaCompletaDto)
      .subscribe(r => this.listaProdotti = r.listaProdotti);
  }
//
  ricercaPaginata(numPagina: number, criterioRicerca?: String) {
    console.log("numero di pagina per ricerca: ", numPagina)
    let dto = new ChiediPaginaDto();
    dto.criterioRicerca = this.inputRicerca;
    dto.numeroPagina = numPagina;
    this.http.post<ListaPagineDto>("http://localhost:8080/ricerca-prodotti-paginata", dto)
      .subscribe(pc => {
        this.listaProdotti = pc.listaPagine;
        console.log(pc.listaPagine);
        this.paginaCorrente = pc.pageNum;
        console.log(pc.pageNum);
        this.numeroPagine = pc.totalPages;
        console.log(this.numeroPagine);
      });
  }

  modifica() {
    this.automa.next(new ModificaEvent(), this.automa);
  }

  conferma() {
    this.automa.next(new ConfermaEvent(), this.automa);
  }

  annulla() {
    this.prodotto = new Prodotto();
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

  seleziona(p: Prodotto) {
    this.selezionaProdotto(p);
    this.automa.next(new SelezionaEvent(), this.automa);
  }

  primo(event: PaginaDto) {
    this.ricercaPaginata(event.pageNum);
  }
  precedente(event: PaginaDto) {
    this.ricercaPaginata(event.pageNum);
  }
  numero(event: PaginaDto) { }
  successivo(event: PaginaDto) {
    this.ricercaPaginata(event.pageNum);
  }
  ultimo(event: PaginaDto) {
    this.ricercaPaginata(event.pageNum);
   }

}
