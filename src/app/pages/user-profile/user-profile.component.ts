import { StringMapWithRename } from '@angular/compiler/src/compiler_facade_interface';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/authentication/services/auth.service';
import { DonneurService } from 'src/app/services/donneur/donneur.service';
import { FormBuilder, FormControl } from '@angular/forms';
import { Don } from 'src/app/models/don';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})


export class UserProfileComponent implements OnInit {
  


  constructor(private authService: AuthService, private donneurService: DonneurService, private formBuilder: FormBuilder) { }
  public dons:Don[] = [];
  public nDons: number;
  checkoutForm = this.formBuilder.group({
    id_donneur: this.authService.userId,
    usernameField: new FormControl(),
    prenomField: new FormControl(),
    nomField: new FormControl(),
    emailField: new FormControl(),
    villeField: new FormControl(),
    paysField:new FormControl(),
    addressField: new FormControl(),
    descField: new FormControl()
  });
  
  onSubmit(): void {
    console.log(this.checkoutForm.value);
    this.donneurService.updateDonneurInfo(this.checkoutForm.value);
  }

  get email() { return this.checkoutForm.get('emailField').value; }
  get username() { return this.checkoutForm.get('usernameField').value; }
  get nom() { return this.checkoutForm.get('nomField').value; }
  get prenom() { return this.checkoutForm.get('prenomField').value; }
  get desc() { return this.checkoutForm.get('descField').value; }
  get nmbDons() {return this.nDons;}


  ngOnInit() {
    this.checkoutForm.controls['usernameField'].disable();
    if(this.authService.role == 'D') {
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
        console.log(response)
        this.checkoutForm.patchValue({descField: response.desc_donneur}),
        this.checkoutForm.patchValue({emailField: response.email});
        this.checkoutForm.patchValue({usernameField: response.username});
        this.checkoutForm.patchValue({addressField: response.addrDonneur});
        this.checkoutForm.patchValue({nomField: response.nomDonneur});
        this.checkoutForm.patchValue({prenomField: response.prenomDonneur});
        this.checkoutForm.patchValue({villeField: response.ville});
        this.checkoutForm.patchValue({paysField: response.pays});
      });
      this.donneurService.getUserDons().subscribe(response => {
        this.dons = response;
        this.nDons = response.length;
      },err => console.log(err));
    }
    else {
      //Association
    }
  }

  }
