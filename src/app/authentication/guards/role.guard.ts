import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, CanActivateChild, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate, CanActivateChild {

  constructor(private authService: AuthService) {

  }
  
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let roles: Array<string> = route.data.roles as Array<string>;

      console.log(roles[0] + " " + this.authService.role);

      if (roles[0] == this.authService.role) {
        console.log("You are authorized");
        return true;
      }
      console.log("You are not authorized");
      return false;
  }

  canActivateChild(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      let roles: Array<string> = route.data.roles as Array<string>;

      console.log(roles[0] + " " + this.authService.role);

      if (roles[0] == this.authService.role) {
        console.log("You are authorized");
        return true;
      }
      console.log("You are not authorized");
      return false;
  }
  
}
