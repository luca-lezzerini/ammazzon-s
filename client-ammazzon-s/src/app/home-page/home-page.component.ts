import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css', '../theme.css']
})
export class HomePageComponent implements OnInit {

  paginaCorrente = 1;
  numeroPagine = 5;

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

  immagine1: string = "assets/css/1.jpg";
  immagine2: string = "assets/css/2.jpg";
  immagine3: string = "assets/css/3.jpg";
  immagine4: string = "assets/css/4.jpg";
  immagine5: string = "assets/css/5.jpg";
  immagine6: string = "assets/css/6.jpg";

  primo(event) {
    console.log(event);
  }
  successivo(event) {
    console.log(event);
  }
  numero(event) {
    console.log(event);
  }
  precedente(event) {
    console.log(event);
  }
  ultimo(event) {
    console.log(event);
  }
}
