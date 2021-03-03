import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/authentication/services/auth.service';
import { SERVER_ADDRESS } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DonneurService {


  constructor(private authService: AuthService, private httpClient: HttpClient) { }
  //registration 
  //authentication

  //http request (refresh_token,)
  //token, refresh_token, date_de_creation, date_expiration, user_id
  //refresh_token

  /*
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    this.http.get<RequestInformationVerification[]>(SERVER_URL, { headers: HEADERS })
  */

  public getUserchihaja(){

    const SERVER_URL = SERVER_ADDRESS + `/donneur/${this.authService.userId}`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.get(SERVER_URL, { headers: HEADERS });
  }

  //methodes ici
}
