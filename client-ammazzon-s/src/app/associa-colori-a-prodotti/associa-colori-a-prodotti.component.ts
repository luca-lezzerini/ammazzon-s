import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ListaProdottiDto } from '../dto/lista-prodotti-dto';
import { RicercaColoreOProdottoDto } from '../dto/ricerca-colore-o-prodotto-dto';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';

@Component({
  selector: 'app-associa-colori-a-prodotti',
  templateUrl: './associa-colori-a-prodotti.component.html',
  styleUrls: ['./associa-colori-a-prodotti.component.css']
})
export class AssociaColoriAProdottiComponent implements OnInit {

  inputRicerca = "";
  prodotti: Prodotto[] = [];
  url = "http://localhost:8080/";
  messaggioErrore = "";
  coloriAssociati: ProdottoColore[] = [];

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

  seleziona() { }

  spostaNonAssociati() { }
  associaTutti() { }
  disassociaTutti() { }

}
