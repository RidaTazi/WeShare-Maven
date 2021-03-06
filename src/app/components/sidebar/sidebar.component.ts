import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/authentication/services/auth.service';

declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}

export const AssociationRoutes: RouteInfo[] = [
  { path: '/publication', title: 'Publications',  icon:'ni-notification-70 text-pink', class: '' },
  { path: '/stock', title: 'Stock',  icon:'ni-money-coins text-yellow', class: '' },
  { path: '/user-profile', title: 'Profile',  icon:'ni-single-02 text-blue', class: '' },
];

export const DonneurRoutes: RouteInfo[] = [
  { path: '/accueil', title: 'Accueil',  icon:'ni-notification-70 text-pink', class: '' },
  { path: '/don', title: 'Don',  icon:'ni-satisfied text-yellow', class: '' },
  { path: '/user-profile', title: 'Profile',  icon:'ni-single-02 text-blue', class: '' },
];


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  public menuItems: any[];
  public isCollapsed = true;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {

    if (this.authService.role === "A") {
      this.menuItems = AssociationRoutes.filter(menuItem => menuItem);
    } 
    else {
      this.menuItems = DonneurRoutes.filter(menuItem => menuItem);
    }

    this.router.events.subscribe((event) => {
      this.isCollapsed = true;
   });
  }

  logout() {
    this.authService.logout();
  }

}
