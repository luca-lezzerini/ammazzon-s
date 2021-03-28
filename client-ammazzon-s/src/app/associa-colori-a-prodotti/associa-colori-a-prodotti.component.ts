import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { ListaProdottoColoriDto } from '../dto/lista-prodotto-colori-dto';
import { ProdottoDto } from '../dto/prodotto-dto';
import { RicercaColoreOProdottoDto } from '../dto/ricerca-colore-o-prodotto-dto';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';
import { VarianteColore } from '../entità/variante-colore';

@Component({
  selector: 'app-associa-colori-a-prodotti',
  templateUrl: './associa-colori-a-prodotti.component.html',
  styleUrls: ['./associa-colori-a-prodotti.component.css', '../theme.css']
})
export class AssociaColoriAProdottiComponent implements OnInit {

  inputRicerca = "";
  prodotti: Prodotto[] = [];
  prodotto = new Prodotto();
  url = "http://localhost:8080/";
  messaggioErrore = "";
  coloriAssociati: ProdottoColore[] = [];
  elencoColoriNonAssociati: VarianteColore[] = [];
  associazione = false;
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaColoreOProdottoDto();
    dto.criterioRicerca = this.inputRicerca;
    if (this.inputRicerca == "") {
      this.messaggioErrore = "ERRORE! Devi inserire un criterio di ricerca";
    } else {
      this.messaggioErrore = "";
      this.http.post<ListaProdottiDto>(this.url + "cerca-prodotto", dto)
        .subscribe(r => {
          this.prodotti = r.listaProdotti;
          this.inputRicerca = "";
        });
    }
  }

  seleziona(pc: Prodotto) {
    this.prodotto = pc;
    let dto = new ProdottoDto();
    //Preparo la richiesta
    dto.prodotto = this.prodotto;
    this.http.post<ListaProdottoColoriDto>(this.url + "seleziona-prodotto", dto)
      .subscribe(r => {
        this.coloriAssociati = r.listaProdottoColori;
      });
  }

  spostaNonAssociati(c: ProdottoColore) { }
  associaTutti() { }
  disassociaTutti() { }
  associaColore(vc: VarianteColore) { }

}
