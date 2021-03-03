import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/authentication/services/auth.service';
import { SERVER_ADDRESS } from 'src/environments/environment';
import {Publication} from 'src/app/models/publication';



@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  /*
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    this.httpClient.get<RequestInformationVerification[]>(SERVER_URL, { headers: HEADERS })
  */

  constructor(private authService: AuthService, private httpClient: HttpClient) { }

   getPubsByAssocId(){
   	const SERVER_URL = SERVER_ADDRESS + `/association/${this.authService.userId}/publications`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.get<Publication[]>(SERVER_URL, { headers: HEADERS });
  }
}
