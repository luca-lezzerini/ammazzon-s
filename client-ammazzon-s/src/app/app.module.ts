import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomePageComponent } from './home-page/home-page.component';
import { AnagraficaColoriGalliComponent } from './anagrafica-colori-galli/anagrafica-colori-galli.component';
import { AnagraficaTagliaComponent } from './anagrafica-taglia/anagrafica-taglia.component';
import { AnagraficaUtenteRegistratoComponent } from './anagrafica-utente-registrato/anagrafica-utente-registrato.component';
import { AssociaTaglieProdottiColoriComponent } from './associa-taglie-prodotti-colori/associa-taglie-prodotti-colori.component';
import { AssociaColoriAProdottiComponent } from './associa-colori-a-prodotti/associa-colori-a-prodotti.component';
import { AppPaginateComponent } from './app-paginate/app-paginate.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AnagraficaColoriGalliComponent,
    AnagraficaTagliaComponent,
    AnagraficaUtenteRegistratoComponent,
    AssociaTaglieProdottiColoriComponent,
    AssociaColoriAProdottiComponent,
    AppPaginateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
