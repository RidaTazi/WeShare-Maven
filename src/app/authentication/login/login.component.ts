import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgbToast } from '@ng-bootstrap/ng-bootstrap';
import { ExchangeService } from 'src/app/services/exchange.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {

  constructor(private authService: AuthService, public exchangeService: ExchangeService) { }

  ngOnInit() {
    this.exchangeService.data.isLoading = false;
  }

  onSubmit(authentificationForm: NgForm) {
    
    console.log(authentificationForm.value);

    if (!authentificationForm.valid) {
      return;
    }

    const username = authentificationForm.value.username;
    const password = authentificationForm.value.password;

    this.exchangeService.data['isLoading'] = true;
    this.authService.login(username, password);
    
    authentificationForm.reset();

  }

  ngOnDestroy() {

  }

}

