import { StringMapWithRename } from '@angular/compiler/src/compiler_facade_interface';
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
  donneur = {	
    idDonneur: 1,	
    dons: null,	
    nomDonneur: "tazi",	
    prenomDonneur: "rida",	
    addrDonneur: "rabat qamra Ahsen dar fl3alam",	
    roleUser: null,	
    email: null,	
    username: null,	
    password: null,	
    idUser: null	
  };
  ngOnInit() {
    this.donneurService.getUserchihaja().subscribe((response :{	
      idDonneur: number,	
      dons: string,	
      nomDonneur: string,	
      prenomDonneur: string,	
      addrDonneur: string,	
      roleUser: string,	
      email:string,	
      username: string,	
      password: string,	
      idUser: string	
    })=>{console.log("AAAAAAAAAAAAAAAAAAA");
      console.log(response)
      this.donneur = response;}
     
    )}
  }
