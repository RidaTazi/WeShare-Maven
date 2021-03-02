import { Routes } from '@angular/router';

import { LoginComponent } from '../../authentication/login/login.component';
import { RegisterComponent } from '../../authentication/register/register.component';

export const AuthLayoutRoutes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login',          component: LoginComponent },
    { path: 'register',       component: RegisterComponent }
];
