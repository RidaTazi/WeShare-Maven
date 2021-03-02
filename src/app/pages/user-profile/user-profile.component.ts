import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { DataService } from './data.service';
import { AuthService } from 'src/app/authentication/services/auth.service';
import { DonneurService } from 'src/app/services/donneur/donneur.service';



@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})


export class UserProfileComponent implements OnInit {
  
  donneur = {
    "idDonneur": 1,
    "dons": null,
    "nomDonneur": "tazi",
    "prenomDonneur": "rida",
    "addrDonneur": "rabat qamra Ahsen dar fl3alam",
    "roleUser": null,
    "email": null,
    "username": null,
    "password": null,
    "idUser": null
  };

  constructor(private authService: AuthService, private donneurService: DonneurService) { }

  ngOnInit() {
    this.donneurService.getUserchihaja().subscribe((response: { id: string, username: string}) => {
     
    })

  }

}
