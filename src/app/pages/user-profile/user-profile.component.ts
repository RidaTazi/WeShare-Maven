import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/authentication/services/auth.service';
import { DonneurService } from 'src/app/services/donneur/donneur.service';


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})


export class UserProfileComponent implements OnInit {
  

  constructor(private authService: AuthService, private donneurService: DonneurService) { }

  ngOnInit() {
  }

}
