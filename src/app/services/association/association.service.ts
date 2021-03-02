import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/authentication/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  /*
    const HEADERS = new HttpHeaders().set("Authorization", "Token " + this.authService.token);
    this.http.get<RequestInformationVerification[]>(SERVER_URL, { headers: HEADERS })
  */

  constructor(private authService: AuthService, private http: HttpClient) { }

  //methode ici
}
