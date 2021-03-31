import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AssociaTagliaRequestDto } from '../dto/associa-taglia-request-dto';
import { DisassociaTagliaRequestDto } from '../dto/disassocia-taglia-request-dto';
import { ListaColoreTagliaDto } from '../dto/lista-colore-taglia-dto';
import { ListaColoriDto } from '../dto/lista-colori-dto';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { ListaProdottoColoriDto } from '../dto/lista-prodotto-colori-dto';
import { ListaTagliaProdottoDto } from '../dto/lista-taglia-prodotto-dto';
import { ProdottoColoreDto } from '../dto/prodotto-colore-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { RicercaStringaReqDto } from '../dto/ricerca-stringa-req-dto';
import { RimuoviTagliaProdottoDto } from '../dto/rimuovi-taglia-prodotto-dto';
import { TagliaDto } from '../dto/taglia-dto';
import { ColoreTaglia } from '../entità/colore-taglia';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';
import { VarianteColore } from '../entità/variante-colore';
import { VarianteTaglia } from '../entità/variante-taglia';

@Component({
  selector: 'app-associa-taglie-prodotti-colori',
  templateUrl: './associa-taglie-prodotti-colori.component.html',
  styleUrls: ['./associa-taglie-prodotti-colori.component.css', '../theme.css']
})
export class AssociaTaglieProdottiColoriComponent implements OnInit {

  constructor(private http: HttpClient) { }

  criterioRicerca = "";
  prodottoSelezionato = new Prodotto();
  prodottoColoreSelezionato = new ProdottoColore();
  //colori taglie non associati a ProdottoColore
  taglieNonAssociate: VarianteTaglia[] = [];
  rimuoviTaglieProdotti = new ColoreTaglia();
  prodotti: Prodotto[] = []
  prodottiColore: ProdottoColore[] = [];
  coloriTaglie: ColoreTaglia[] = [];
  messaggioErrore = "";
  



  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaStringaReqDto();
    dto.criterioRicerca = this.criterioRicerca;
    this.http.post<ListaProdottiDto>("http://localhost:8080/cerca-prodotti-codice-esatto-descrizione-like", dto)
      .subscribe(l => {
        if (l.listaProdotti.length < 1) {
          this.messaggioErrore = "Nessun prodotto trovato"
          this.prodotti = l.listaProdotti;
        } else {
          this.messaggioErrore = "";
          this.prodotti = l.listaProdotti;
        }
        this.prodottiColore = [];
        this.coloriTaglie = [];
        this.taglieNonAssociate = [];
      });
  }

  selezionaProdotto(p: Prodotto) {
    this.prodottoSelezionato = p;
    let dto = new ProdottoDto();
    dto.prodotto = p;
    console.log("id prodotto selezionato: ", dto.prodotto.id);
    this.http.post<ListaProdottoColoriDto>("http://localhost:8080/cerca-colori-associati-prodotto", dto)
      .subscribe(lc => {
        if (lc.listaProdottoColori) {
          this.prodottiColore = lc.listaProdottoColori;
        }
        console.log(lc)
        this.coloriTaglie = [];
        this.taglieNonAssociate = [];
      });
  }
  selezionaProdottoColore(pc: ProdottoColore) {
    this.prodottoColoreSelezionato = pc;
    let dto = new ProdottoColoreDto();
    dto.prodottoColore = pc;
    this.http.post<ListaColoreTagliaDto>("http://localhost:8080/cerca-ColoreTaglia-associati-prodottoColore", dto)
      .subscribe(ct => {
        this.coloriTaglie = ct.coloriTaglie;
        this.taglieNonAssociate = ct.notColoriTaglie;
        console.log("taglie non associate: ", ct.notColoriTaglie);
      });
  }

  rimuoviTagliaProdotto(ct: ColoreTaglia) {
    let dtoReq = new DisassociaTagliaRequestDto();
    dtoReq.idProdottoColore = this.prodottoColoreSelezionato.id;
    dtoReq.idColoreTaglia = ct.id
    this.http.post<ListaColoreTagliaDto>("http://localhost:8080/disassocia-taglia", dtoReq)
      .subscribe(ct => {
        this.coloriTaglie = ct.coloriTaglie;
        this.taglieNonAssociate = ct.notColoriTaglie;
      });
  }

  associaTagliaProdottoColore(vt: VarianteTaglia) {
    let dtoReq = new AssociaTagliaRequestDto();
    dtoReq.pc = this.prodottoColoreSelezionato;
    dtoReq.vt = vt;
    this.http.post<ListaColoreTagliaDto>("http://localhost:8080/associa-taglia", dtoReq)
      .subscribe(ct => {
        this.coloriTaglie = ct.coloriTaglie;
        this.taglieNonAssociate = ct.notColoriTaglie;
      });
  }

  associaTutti() {
    //////////////lOGICA///////////////////////
    //prima disassocia da tutti
    //recupera tutte le taglie 
    //le associa tutte al prodottoColore ricevuto
    //aggiorna client
    this.disassociaTutti();
    let dto = new ProdottoColoreDto();
    dto.prodottoColore = this.prodottoColoreSelezionato;
    this.http.post<ListaColoreTagliaDto>("http://localhost:8080/associa-tutti", dto)
      .subscribe(ct => {
        this.coloriTaglie = ct.coloriTaglie;
        this.taglieNonAssociate = ct.notColoriTaglie;
      });
  }


  disassociaTutti() {
    let dto = new ProdottoColoreDto();
    dto.prodottoColore = this.prodottoColoreSelezionato;
    this.http.post<ListaColoreTagliaDto>("http://localhost:8080/disassocia-tutti", dto)
      .subscribe(ct => {
        this.coloriTaglie = ct.coloriTaglie;
        this.taglieNonAssociate = ct.notColoriTaglie;
      });
  }


}



