import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthService } from '../shared/services/auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router, private auth: AuthService) { }

    canActivate(): boolean {
        if (this.auth.authenticated()) {
            // logged in so return true
            return true;
        }

        // not logged in so redirect to login page
        this.router.navigate(['/login']);
        return false;
    }
}