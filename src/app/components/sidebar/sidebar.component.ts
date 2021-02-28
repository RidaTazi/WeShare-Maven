import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/dashboard', title: 'Dashboard',  icon: 'ni-tv-2 text-primary', class: '' },
    { path: '/user-profile', title: 'Profil',  icon:'ni-single-02 text-yellow', class: '' },
    { path: '/cv', title: 'CV',  icon:'ni-badge text-pink', class: '' },
    { path: '/offres', title: 'Offres',  icon:'ni-notification-70 text-blue', class: '' },
    { path: '/tables', title: 'Candidatures',  icon:'ni-bullet-list-67 text-red', class: '' },
    { path: '/login', title: 'Logout',  icon:'ni-user-run text-yellow', class: '' },

];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  public menuItems: any[];
  public isCollapsed = true;

  constructor(private router: Router) { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
    this.router.events.subscribe((event) => {
      this.isCollapsed = true;
   });
  }
}
