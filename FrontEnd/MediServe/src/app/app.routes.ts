import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BannerManagerComponent } from './admin/banner-manager/banner-manager.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'admin/banners', component: BannerManagerComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' } // Redirect any unknown paths to home
];
