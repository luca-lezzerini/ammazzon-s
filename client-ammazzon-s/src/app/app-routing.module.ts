import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
 {path: 'app-home-page', component: HomePageComponent },

 { path: '', redirectTo: '/app-home-page', pathMatch: 'full' },
 { path: '', redirectTo: '/app-user-interface', pathMatch: 'full' }

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
