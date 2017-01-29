import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthGuard } from './guards/auth.guard';

import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AccountComponent } from './account/account.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
	{
		path: '',
        redirectTo: '/login',
  		pathMatch: 'full'
	}, {
        path: 'login',
        component: LoginComponent
    }, {
        path: 'signup',
        component: SignupComponent
    }, {
		path: 'account',
		component: AccountComponent,
        canActivate: [AuthGuard] 
	}, {
		path: 'home',
		component: HomeComponent,
		canActivate: [AuthGuard]
	}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);