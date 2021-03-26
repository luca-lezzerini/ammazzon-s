import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnagraficaColoriGalliComponent } from './anagrafica-colori-galli/anagrafica-colori-galli.component';
import { AnagraficaTagliaComponent } from './anagrafica-taglia/anagrafica-taglia.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  { path: 'app-home-page', component: HomePageComponent },

  { path: '', redirectTo: '/app-home-page', pathMatch: 'full' },
  { path: '', redirectTo: '/app-user-interface', pathMatch: 'full' },
  { path: 'app-anagrafica-taglia', component: AnagraficaTagliaComponent },
  { path: 'app-anagrafica-colori-galli', component: AnagraficaColoriGalliComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
