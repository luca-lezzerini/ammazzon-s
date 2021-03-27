import { HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Automa } from '../automa-crud/automa';

@Component({
  selector: 'app-associa-taglie-prodotti-colori',
  templateUrl: './associa-taglie-prodotti-colori.component.html',
  styleUrls: ['./associa-taglie-prodotti-colori.component.css', '../theme.css']
})
export class AssociaTaglieProdottiColoriComponent implements OnInit {

  constructor(private http:HttpClient) { }

  automa: Automa;

  ngOnInit(): void {
  }

  cerca(){}
   
}
