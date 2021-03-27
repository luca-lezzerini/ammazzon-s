import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { RicercaColoreDto } from '../dto/ricerca-colore-dto';
import { RicercaStringaReqDto } from '../dto/ricerca-stringa-req-dto';
import { ColoreTaglia } from '../entità/colore-taglia';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';

@Component({
  selector: 'app-associa-taglie-prodotti-colori',
  templateUrl: './associa-taglie-prodotti-colori.component.html',
  styleUrls: ['./associa-taglie-prodotti-colori.component.css', '../theme.css']
})
export class AssociaTaglieProdottiColoriComponent implements OnInit {

  constructor(private http: HttpClient) { }

  criterioRicerca = "";
  prodotto = new Prodotto();
  prodotti: Prodotto[] = []
  prodottiColore: ProdottoColore[] = [];
  coloriTaglie: ColoreTaglia[] = [];



  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaStringaReqDto();
    dto.criterioRicerca = this.criterioRicerca;
    this.http.post<ListaProdottiDto>("http://localhost:8080/cerca-prodotti-codice-esatto-descrizione-like", dto)
      .subscribe(l => {
        this.prodotti = l.listaProdotti;
      });
  }
  selezionaProdotto() { }
  selezionaProdottoColore() { }
  rimuoviTagliaProdotto() { }


}
