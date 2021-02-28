import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  user:User;

  constructor() { }

  ngOnInit() {
    this.user = {
      nom: "Sabour",
      prenom: "Zakaria",
      username: "ZakariaSabour",
      email: "zakaria.sabour@gmail.com",
      addresse: "Casablanca,Maroc",
      tel: "07453454553",
      ville: "Casablanca",
      pays: "Maroc"
    }
  }

}


interface User
{
  nom,
  prenom,
  username,
  email,
  addresse,
  tel,
  ville,
  pays
}
