import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SERVER_ADDRESS } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _userId: string;
  private _username: string;
  private _role: string;
  private _token: string;

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) { }

  get userId(): string {
    return this._userId;
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

    const SERVER_URL = SERVER_ADDRESS + "/user/register";
    
    const BODY = {
      username: username,
      password: password,
      role: role
    };

    console.log(BODY);

    this.http.post(SERVER_URL, BODY)
      .subscribe((response: { id: string, username: string, role: string, token: string }) => {
        
        console.log(response);

        this._userId = response.id;
        this._username = response.username;
        this._role = response.role;
        this._token = response.token;

        if (this._token) {

          localStorage.setItem("userData", JSON.stringify({
            userId: this._userId,
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

    const SERVER_URL = SERVER_ADDRESS + "/user/auth";
    
    const BODY = {
      username: username,
      password: password
    }

    this.http.post(SERVER_URL, BODY)
    .subscribe((response: {userId: string, username: string, role: string, token: string}) => {
      
      console.log(response);
    

      this._userId = response.userId;
      this._username = response.username;
      this._role = response.role; //must be change to reponse.role
      this._token = response.token;

      if (this._token) {

        localStorage.setItem("userData", JSON.stringify({
            userId: this._userId,
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
      else {
        console.log("You are not authorized");
      }

    }, error => {
      console.log(error);
    })
  }

  autoLogin() {

    const userData : {
      userId: string;
      username: string;
      role: string;
      token: string;
    } = JSON.parse(localStorage.getItem('userData'));

    if (!userData) {
      this.router.navigate(['/login']);
      return;
    }

    if (userData.token) {
      this._userId = userData.userId;
      this._username = userData.username;
      this._role = userData.role;
      this._token = userData.token;

      if (this._role === 'A') {
        this.router.navigate(['/association']);
      }
      else if (this._role === 'D') {
        this.router.navigate(['/donneur']);
      }
    }
  }

  logout() {
    
    this._username = null;
    this._userId = null;
    this._role = null;
    this._token = null;
    
    localStorage.removeItem("userData");
    this.router.navigate(["/login"]);
  }
}
