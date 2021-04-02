import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { PaginaDto } from '../app-paginate/pagina-dto';
import { Automa } from '../automa-crud/automa';
import { Automabile } from '../automa-crud/automabile';
import { AddEvent, AnnullaEvent, ConfermaEvent, ModificaEvent, RicercaEvent, RimuoviEvent, SelezionaEvent } from '../automa-crud/eventi';
import { ListaPagineDto } from '../dto/lista-pagine-dto';
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
    let dto = new PaginaDto();
    dto.pageNum = 1;
    this.aggiorna(dto);
  }

  ngOnInit(): void {
  }

  primo(event: PaginaDto) {
    console.log(event);
    this.aggiorna(event);
  }
  successivo(event: PaginaDto) {
    this.aggiorna(event);
    console.log(event);
  }
  numero(event: PaginaDto) {
    console.log(event);
    this.aggiorna(event);
  }
  precedente(event: PaginaDto) {
    this.aggiorna(event);
    console.log(event);
  }
  ultimo(event: PaginaDto) {
    console.log(event);
    this.aggiorna(event);
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
    dto.pageNum = this.paginaCorrente;
    this.http.post<ListaPagineDto>("http://localhost:8080/aggiungi-taglia", dto)
      .subscribe(r => {
        this.listaTaglie = r.listaPagine;
        this.paginaCorrente = r.pageNum + 1;
        this.numeroPagine = r.totalPages;
        this.taglia = new VarianteTaglia();
      });
  }

  modificaDati() {
    let dto = new TagliaDto();
    dto.varianteTaglia = this.taglia;
    dto.pageNum = this.paginaCorrente;
    this.http.post<ListaPagineDto>("http://localhost:8080/conferma-taglia", dto)
      .subscribe(r => {
        this.listaTaglie = r.listaPagine;
        this.paginaCorrente = r.pageNum + 1;
        this.numeroPagine = r.totalPages;
      });
    // this.aggiorna(dto);
  }

  eliminaDati() {
    let dto = new TagliaDto();
    dto.varianteTaglia = this.taglia;
    dto.pageNum = this.paginaCorrente;
    this.http.post<ListaPagineDto>("http://localhost:8080/rimuovi-taglia", dto)
      .subscribe(r => {
        this.listaTaglie = r.listaPagine;
        this.paginaCorrente = r.pageNum + 1;
        this.numeroPagine = r.totalPages;
      });
    // this.aggiorna(dto);
  }

  aggiornaRisultatiRicerca() {
    let dto = new RicercaTaglieDto();
    dto.criterioRicerca = this.inputRicerca;
    dto.pageNum = this.paginaCorrente;
    dto.totalPages = this.numeroPagine;
    if (this.inputRicerca == null) {
      this.errore = "Inserisci il criterio di ricerca";
    } else {
      this.errore = "";
      this.http.post<ListaPagineDto>("http://localhost:8080/ricerca-taglia", dto)
        .subscribe(r => {
            this.listaTaglie = r.listaPagine;
            this.paginaCorrente = r.pageNum + 1;
            this.numeroPagine = r.totalPages;
        });
    }
  }

  ritornaTaglia(l: VarianteTaglia) {
    let dto = new TagliaDto();
    dto.varianteTaglia = l;
    dto.pageNum = this.paginaCorrente;
    this.http.post<TagliaDto>("http://localhost:8080/rit-taglia", dto)
      .subscribe(r => {
        this.taglia = r.varianteTaglia;
        this.paginaCorrente = r.pageNum;
        this.numeroPagine = r.totalPages;
      });
  }

  aggiorna(dto: PaginaDto) {
    let dto2 = new TagliaDto();
    dto2.pageNum = dto.pageNum;
    console.log(dto2.pageNum);

    this.http.post<ListaPagineDto>("http://localhost:8080/aggiorna-taglia", dto2)
      .subscribe(r => {
        this.listaTaglie = r.listaPagine;
        this.paginaCorrente = r.pageNum + 1;
        this.numeroPagine = r.totalPages;
      });
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
