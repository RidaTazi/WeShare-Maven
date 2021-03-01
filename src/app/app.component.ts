import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './authentication/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'argon-dashboard-angular';

  constructor(private authService: AuthService, private router: Router) {

  }

  ngOnInit() {
    this.authService.autoLogin();
    this.router.navigate(['/login']);
  }


  
}
