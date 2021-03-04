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

  public getUserDons(){

    const SERVER_URL = SERVER_ADDRESS + `/donneur/${this.authService.userId}/dons`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.get(SERVER_URL, { headers: HEADERS });
  }

  public addDon(don){
    const SERVER_URL = SERVER_ADDRESS + `/donneur/${this.authService.userId}/addDon`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);

    return this.httpClient.post(SERVER_URL,don,{headers : HEADERS})
  }

  public getUserchihaja(){

    const SERVER_URL = SERVER_ADDRESS + `/donneur/${this.authService.userId}`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.get(SERVER_URL, { headers: HEADERS });
  }
  

  public updateDonneurInfo(object) {
    console.log(object);
    const SERVER_URL = SERVER_ADDRESS + "/donneur/update";
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.post(SERVER_URL, object, { headers: HEADERS });
  }


}

interface Don {
  association,
  date,
  desc,
  donneur,
  etatInfo,
  iD,
  logo,
  publication,
  state,
  type
}
