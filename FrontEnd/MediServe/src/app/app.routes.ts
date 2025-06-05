import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BannerManagerComponent } from './admin/banner-manager/banner-manager.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { PlaceholderComponent } from './placeholder/placeholder.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignUpComponent },
  { path: 'cart', component: PlaceholderComponent },
  { path: 'account', component: PlaceholderComponent },
  { path: 'admin/banners', component: BannerManagerComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' } // Redirect any unknown paths to home
];