import { PaginaDto } from './pagina-dto';
import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-app-paginate',
  templateUrl: './app-paginate.component.html',
  styleUrls: ['./app-paginate.component.css', '../theme.css']
})
export class AppPaginateComponent implements OnInit {

  constructor(private http: HttpClient) { }

  @Input() pagina: number;
  @Input() totali: number;

  @Output() primo: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() precedente: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() numero: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() successivo: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() ultimo: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();
  @Output() cambiaPagina: EventEmitter<PaginaDto> = new EventEmitter<PaginaDto>();

  paginaDto = new PaginaDto();

  url = "http://localhost:8080/";

  ngOnInit(): void {
    console.log(this.pagina);
    console.log(this.totali);
    this.paginaDto.pageNum = this.pagina;
    this.paginaDto.totalPages = this.totali;
  }



  onFirst() {
    this.paginaDto.totalPages = this.totali;
    this.pagina = 1;
    this.paginaDto.pageNum = this.pagina;
    this.primo.emit(this.paginaDto)
    this.cambiaPagina.emit(this.paginaDto);
  }
  onPrevious() {
    this.paginaDto.totalPages = this.totali;
    this.pagina--;
    this.paginaDto.pageNum = this.pagina;
    this.precedente.emit(this.paginaDto);
    this.cambiaPagina.emit(this.paginaDto);
  }
  onNext() {
    this.paginaDto.totalPages = this.totali;
    this.pagina++;
    this.paginaDto.pageNum = this.pagina;
    this.successivo.emit(this.paginaDto);
    this.cambiaPagina.emit(this.paginaDto);
  }

  onFin() {
    this.paginaDto.totalPages = this.totali;
    this.pagina = this.paginaDto.totalPages;
    this.paginaDto.pageNum = this.pagina;
    this.ultimo.emit(this.paginaDto);
    this.cambiaPagina.emit(this.paginaDto);
  }

  numeroPagina() {
    this.paginaDto.pageNum = this.pagina;
    this.numero.emit(this.paginaDto);
    this.cambiaPagina.emit(this.paginaDto);
  }


}
