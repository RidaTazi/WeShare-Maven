import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {
  
  public isLoading: boolean;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.isLoading = false;
  }

  onSubmit(authentificationForm: NgForm) {
    
    console.log(authentificationForm.value);

    if (!authentificationForm.valid) {
      return;
    }

    const username = authentificationForm.value.username;
    const password = authentificationForm.value.password;

    this.isLoading = true;
    this.authService.login(username, password);
    
    authentificationForm.reset();

  }

  ngOnDestroy() {

  }

}

