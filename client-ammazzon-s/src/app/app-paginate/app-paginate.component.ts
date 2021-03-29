import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-app-paginate',
  templateUrl: './app-paginate.component.html',
  styleUrls: ['./app-paginate.component.css']
})
export class AppPaginateComponent implements OnInit {

  constructor(private http: HttpClient) { }

  //@Input() numeroPaginaCorrente: number;
  @Input() totalPages : number;
  //numeroMaxPagine: number;
  url = "http://localhost:8080/";

  ngOnInit(): void {
  }

 // vaiAPrimaPagina() {

 // }

  ///vaiAPrecedente() {

  //}

  ///vaiASuccessivo() {

  //}

  ///vaiAUltima() {

  //}
  onNext(){}

  onLast(){}


}
