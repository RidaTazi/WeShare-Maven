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
    desc_donneur: "description",
    idDonneur: 1,	
    dons: null,	
    pays: "pays",
    ville: "ville",
    nomDonneur: "nom",	
    prenomDonneur: "prenom",	
    addrDonneur: "adresse",	
    roleUser: null,	
    email: "email",	
    username: "username",	
    password: null,	
    idUser: 1	
  };

  ngOnInit() {
    this.donneurService.getUserchihaja().subscribe((response :{	
      desc_donneur: string,
      idDonneur: number,	
      dons: string,	
      pays: string,
      ville: string,
      nomDonneur: string,	
      prenomDonneur: string,	
      addrDonneur: string,	
      roleUser: string,	
      email:string,	
      username: string,	
      password: string,	
      idUser: number	
    })=>{
      console.log(`role` + this.authService.role);
      console.log(response)
      this.donneur = response;
    }
     
    )}

  }
