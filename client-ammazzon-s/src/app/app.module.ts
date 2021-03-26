import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HomePageComponent } from './home-page/home-page.component';
import { CrudGenericaGalComponent } from './crud-generica-gal/crud-generica-gal.component';
import { AnagraficaTagliaComponent } from './anagrafica-taglia/anagrafica-taglia.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    CrudGenericaGalComponent,
    AnagraficaTagliaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
