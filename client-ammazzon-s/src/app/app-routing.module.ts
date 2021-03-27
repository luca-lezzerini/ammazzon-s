import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnagraficaColoriGalliComponent } from './anagrafica-colori-galli/anagrafica-colori-galli.component';
import { AnagraficaTagliaComponent } from './anagrafica-taglia/anagrafica-taglia.component';
import { AnagraficaUtenteRegistratoComponent } from './anagrafica-utente-registrato/anagrafica-utente-registrato.component';
import { AssociaTaglieProdottiColoriComponent } from './associa-taglie-prodotti-colori/associa-taglie-prodotti-colori.component';
import { AssociaColoriAProdottiComponent } from './associa-colori-a-prodotti/associa-colori-a-prodotti.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  { path: 'app-home-page', component: HomePageComponent },

  { path: '', redirectTo: '/app-home-page', pathMatch: 'full' },
  { path: '', redirectTo: '/app-user-interface', pathMatch: 'full' },
  { path: 'app-anagrafica-taglia', component: AnagraficaTagliaComponent },
  { path: 'app-anagrafica-colori-galli', component: AnagraficaColoriGalliComponent },
  { path: 'app-anagrafica-utente-registrato', component: AnagraficaUtenteRegistratoComponent },
  { path: 'app-associa-taglie-prodotti-colori', component: AssociaTaglieProdottiColoriComponent },
  { path: 'app-associa-colori-a-prodotti', component: AssociaColoriAProdottiComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
