import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { DataService } from './data.service';



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
  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.dataService.sendGetRequest().subscribe((data: any[])=>{
      console.log(data);
      //this.donneur = data;
    })  

  }

}
