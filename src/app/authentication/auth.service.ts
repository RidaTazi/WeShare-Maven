import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { SERVER_ADDRESS } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _id: string;
  private _username: string;
  private _role: string;
  private _token: string;

  constructor(private http: HttpClient, private router: Router) { }

  get userId(): string {
    return this._id;
  }

  get username(): string {
    return this._username;
  }

  get token(): string {
    return this._token;
  }

  get role(): string {
    return this._role;
  }

  signUp(username: string, password: string, role: string) {

    const SERVER_URL = SERVER_ADDRESS + "/register";
    
    const BODY = {
      username: username,
      password: password,
      role: role
    };

    this.http.post(SERVER_URL, BODY)
      .subscribe((response: { id: string, username: string, role: string, token: string }) => {
        
        console.log(response);

        this._id = response.id;
        this._username = response.username;
        this._role = response.role;
        this._token = response.token;

        if (this._token) {

          localStorage.setItem("userData", JSON.stringify({
            id: this._id,
            username: this._username,
            role: this._role,
            token: this._token
          }));

          if (this._role === 'A') {
            this.router.navigate(['/association']);
          }
          else if (this._role === 'D') {
            this.router.navigate(['/donneur']);
          }
          
        }

      }, error => {
        console.log(error);
      })
      
  }

  login(username: string, password: string) {

    const SERVER_URL = SERVER_ADDRESS + "auth/";
    
    const BODY = {
      username: username,
      password: password
    }

    this.http.post(SERVER_URL, BODY)
    .subscribe((response: {id: string, username: string, role: string, token: string}) => {
      
      console.log(response);
    

      this._id = response.id;
      this._username = response.username;
      this._role = response.role; //must be change to reponse.role
      this._token = response.token;

      if (this._token) {

        localStorage.setItem("userData", JSON.stringify({
            id: this._id,
            username: this._username,
            role: this._role,
            token: this._token
        }));

        if (this._role === 'A') {
          this.router.navigate(['/association']);
        }
        else if (this._role === 'D') {
          this.router.navigate(['/Donneur']);
        }

      }
      else {
        console.log("You are not authorized");
      }

    }, error => {
      console.log(error);
    })
  }

  autoLogin() {

    const userData : {
      id: string;
      username: string;
      role: string;
      token: string;
    } = JSON.parse(localStorage.getItem('userData'));

    if (!userData) {
      return;
    }

    if (userData.token) {
      this._id = userData.id;
      this._username = userData.username;
      this._role = userData.role;
      this._token = userData.token;
    }
  }

  logout() {
    
    this._username = null;
    this._id = null;
    this._role = null;
    this._token = null;
    
    localStorage.removeItem("userData");
    this.router.navigate(['/']);
  }
}
