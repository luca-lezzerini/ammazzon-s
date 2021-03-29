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
  @Input() totalPages: number;
  numPag: number = 1;
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
  onfirst() {

  }
  onPrevious() {
//this.totalPages, this.numPag -1;
  }
  onNext() {
   //this.setPage (Math.min(this.totalPages, this.numPag +1)) ;
  }

  onfin() {

  }


}
