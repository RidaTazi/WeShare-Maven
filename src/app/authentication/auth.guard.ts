import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    const userData: {
      userId: string;
      username: string;
      role: string;
      token: string;
    } = JSON.parse(localStorage.getItem("userData"));

    if (userData && userData.token) {
      return true;
    }

    //this.navController.back();
    console.log("You are not allowed to access the page");
    return false;
  }
  
}
