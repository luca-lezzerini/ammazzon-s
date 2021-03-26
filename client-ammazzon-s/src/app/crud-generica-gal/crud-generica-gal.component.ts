import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { VarianteColore } from '../entità/variante-colore';

@Component({
  selector: 'app-crud-generica-gal',
  templateUrl: './crud-generica-gal.component.html',
  styleUrls: ['./crud-generica-gal.component.css']
})
export class CrudGenericaGalComponent implements OnInit {

  varianteColore = new VarianteColore();
  variantiColori: VarianteColore[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

}
