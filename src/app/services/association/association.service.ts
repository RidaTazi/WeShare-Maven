import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/authentication/services/auth.service';
import { SERVER_ADDRESS } from 'src/environments/environment';
import {Publication} from 'src/app/models/publication';
import {Don} from 'src/app/models/don';
import {ExchangeService} from 'src/app/services/exchange.service';


@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  /*
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    this.httpClient.get<RequestInformationVerification[]>(SERVER_URL, { headers: HEADERS })
  */

  constructor(private authService: AuthService, private httpClient: HttpClient,private exchange: ExchangeService) { }

   getPubsByAssocId(){
   	const SERVER_URL = SERVER_ADDRESS + `/association/${this.authService.userId}/publications`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.get<Publication[]>(SERVER_URL, { headers: HEADERS });
  }
  public getAssociationById(){
    const SERVER_URL = SERVER_ADDRESS + `/association/${this.authService.userId}`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);

    return this.httpClient.get(SERVER_URL, { headers: HEADERS });
  }
  getDonsByPubId(){
     const SERVER_URL = SERVER_ADDRESS + `/association/${this.exchange.data.pubId}/dons`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.get<Don[]>(SERVER_URL, { headers: HEADERS });
  }

  deletePubById(id: number){
     const SERVER_URL = SERVER_ADDRESS + `/association/${id}/deletePub`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.post(SERVER_URL, { headers: HEADERS });
  }

  updatePubById(id: number){
    //  const SERVER_URL = SERVER_ADDRESS + `/association/1/${id}/update`;
    // const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    // return this.httpClient.get<Publication[]>(SERVER_URL, { headers: HEADERS });
    console.log(`/association/1/${id}/update`)
  }

  acceptDonById(id: number){
     const SERVER_URL = SERVER_ADDRESS + `/association/${id}/accept`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.post(SERVER_URL, { headers: HEADERS });
  }

    refuseDonById(id: number){
     const SERVER_URL = SERVER_ADDRESS + `/association/${id}/refuse`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.post(SERVER_URL, { headers: HEADERS });
  }


  getAcceptedDonsByPubId(type: String){
     const SERVER_URL = SERVER_ADDRESS + `/association/${this.authService.userId}/acceptedDons/${type}`;
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    return this.httpClient.get<Don[]>(SERVER_URL, { headers: HEADERS });
  }
  //methode ici
}
