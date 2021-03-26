import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomePageComponent } from './home-page/home-page.component';
import { AnagraficaColoriGalliComponent } from './anagrafica-colori-galli/anagrafica-colori-galli.component';
import { AnagraficaTagliaComponent } from './anagrafica-taglia/anagrafica-taglia.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AnagraficaColoriGalliComponent,
    AnagraficaTagliaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
