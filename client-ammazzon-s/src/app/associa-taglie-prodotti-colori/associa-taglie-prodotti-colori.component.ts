import { HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';
import { ColoreTaglia } from '../entità/colore-taglia';
import { Prodotto } from '../entità/prodotto';
import { ProdottoColore } from '../entità/prodotto-colore';

@Component({
  selector: 'app-associa-taglie-prodotti-colori',
  templateUrl: './associa-taglie-prodotti-colori.component.html',
  styleUrls: ['./associa-taglie-prodotti-colori.component.css', '../theme.css']
})
export class AssociaTaglieProdottiColoriComponent implements OnInit {

  constructor(private http:HttpClient) { }

  prodotto = new Prodotto();
  prodotti: Prodotto[]=[]
  prodottiColore: ProdottoColore[] = [];
  coloriTaglie : ColoreTaglia[] = [];

  

  ngOnInit(): void {
  }

  cerca(){}
  selezionaProdotto(){}
  selezionaProdottoColore(){}
  rimuoviTagliaProdotto(){}

   
}
