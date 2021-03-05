import { Component, OnInit } from '@angular/core';
import { AssociationService } from 'src/app/services/association/association.service';
import {Router} from '@angular/router';
import { Observable } from 'rxjs';
import {Publication} from 'src/app/models/publication';
import {ExchangeService} from 'src/app/services/exchange.service';



@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.css']
})
export class PublicationComponent implements OnInit {
	public pubs: Publication[]=[]; 

  constructor(private associationService: AssociationService,private router: Router, private exchange: ExchangeService) { }

  ngOnInit(): void {
  	this.associationService.getPubsByAssocId().subscribe(response=>{
  		this.pubs=response;
  	},err=>{
  		alert("Server Problem !")
  	})
  }

  showDons(id: number){
    this.exchange.data.pubId=id;
  	this.router.navigate(["/publication-dons"]);
  }



  deletePub(idPub: number){
    this.associationService.deletePubById(idPub).subscribe(res=>{
    this.ngOnInit();
    },err=>{
      alert("This Pub couldn't be deleteted, please try later!")
    });
  }

  updatePub(id: number){
    this.associationService.updatePubById(id); 
  }  

}
