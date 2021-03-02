import { Component, OnInit, ElementRef } from '@angular/core';
import { AssociationRoutes, DonneurRoutes } from '../sidebar/sidebar.component';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/authentication/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})

export class NavbarComponent implements OnInit {
  public focus;
  public listTitles: any[];
  public location: Location;
  constructor(private authService: AuthService, location: Location,  private element: ElementRef, private router: Router) {
    this.location = location;
  }

  ngOnInit() {
    if (this.authService.role === "A") {
      this.listTitles= AssociationRoutes.filter(menuItem => menuItem);
    } 
    else {
      this.listTitles = DonneurRoutes.filter(menuItem => menuItem);
    }
  }
  
  getTitle(){
    var titlee = this.location.prepareExternalUrl(this.location.path());
    if (titlee.charAt(0) === '#') {
        titlee = titlee.slice( 1 );
    }

    for(var item = 0; item < this.listTitles.length; item++) {
        if (this.listTitles[item].path === titlee) {
            return this.listTitles[item].title;
        }
    }
    return 'Dashboard';
  }

}
