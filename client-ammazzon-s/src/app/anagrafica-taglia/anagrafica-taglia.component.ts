import { Component, OnInit } from '@angular/core';
import { VarianteTaglia } from '../entità/variante-taglia';

@Component({
  selector: 'app-anagrafica-taglia',
  templateUrl: './anagrafica-taglia.component.html',
  styleUrls: ['./anagrafica-taglia.component.css']
})
export class AnagraficaTagliaComponent implements OnInit {

  criterioRicerca = "";
  taglia = new VarianteTaglia();
  listaTaglie: VarianteTaglia[] = [];
  constructor() { }

  ngOnInit(): void {
  }


  modifica() {

  }
  conferma() {

  }
  annulla() {

  }
  rimuovi() {

  }
  nuova() {

  }
  cerca() {

  }
  seleziona() {

  }
}
