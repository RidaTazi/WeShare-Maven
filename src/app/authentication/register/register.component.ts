import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

export class RegisterComponent implements OnInit, OnDestroy {

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  passwordStrengthChecker(password: String) {

    let strength: number = 0;

    let strengthbar: HTMLInputElement = (<HTMLInputElement>document.getElementById("meter"));

    if (password == null) {
      strengthbar.value = "0";
    }

    console.log(password);
    

    if (password.match(/[a-z]+/)) {
      strength += 1;
    }
    if (password.match(/[A-Z]+/)) {
      strength += 1;
    }
    if (password.match(/[0-9]+/)) {
      strength += 1;
    }
    if (password.match(/[$@#&!]+/)) {
      strength += 1;
    }

    switch (strength) {
      case 0:
        strengthbar.value = "0";
        break;

      case 1:
        strengthbar.value = "25";
        break;

      case 2:
        strengthbar.value = "50";
        break;

      case 3:
        strengthbar.value = "75";
        break;

      case 4:
        strengthbar.value = "100";
        break;
    }
  }

  checkPasswordConfirmation(password: string, password_confirmation: string): boolean {
    return password == password_confirmation;
  }
  

  onSubmit(registrationForm: NgForm) {

    console.log(registrationForm.value);

    //if the user find a way to enable the button event if the form is not valid
    if (!registrationForm.valid || !this.checkPasswordConfirmation(registrationForm.value.password, 
        registrationForm.value.password_confirmation)) {
        return;
    }

    //extract from the form the credentials
    const username = registrationForm.value.username;
    const role = registrationForm.value.role;
    const password = registrationForm.value.password;
    const password_confirmation = registrationForm.value.password;
    
    this.authService.signUp(username, password, role);
    
    registrationForm.reset(); //reset the form

  }

  ngOnDestroy() {

  }

}
