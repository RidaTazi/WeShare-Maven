import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/authentication/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class DonneurService {

  //registration 
  //authentication

  //http request (refresh_token,)
  //token, refresh_token, date_de_creation, date_expiration, user_id
  //refresh_token

  /*
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    this.http.get<RequestInformationVerification[]>(SERVER_URL, { headers: HEADERS })
  */

  constructor(private authService: AuthService, private http: HttpClient) { }

  //methodes ici
}
