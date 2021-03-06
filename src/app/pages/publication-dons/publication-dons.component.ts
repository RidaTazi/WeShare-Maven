import { Component, OnInit } from '@angular/core';
import {ExchangeService} from 'src/app/services/exchange.service';
import { AssociationService } from 'src/app/services/association/association.service';
import {Don} from 'src/app/models/don';

@Component({
  selector: 'app-publication-dons',
  templateUrl: './publication-dons.component.html',
  styleUrls: ['./publication-dons.component.css']
})
export class PublicationDonsComponent implements OnInit {
	public dons: Don[]=[]; 

  constructor(private exchange: ExchangeService,private associationService: AssociationService) {}

  ngOnInit(): void {
  	this.associationService.getDonsByPubId().subscribe(res=>{
  		this.dons=res;
  		console.log(this.dons);
  	},err=>{
  		alert("Can't fetch Donations, please try later!")
  	});
  }

  acceptDon(idDon: number){
    this.associationService.acceptDonById(idDon).subscribe(res=>{
      this.ngOnInit();
    },err=>{
      alert("This Donation couldn't be accepted, please try later!")
    });
  }

  refuseDon(idDon: number){
    this.associationService.refuseDonById(idDon).subscribe(res=>{
      this.ngOnInit();
    },err=>{
      alert("This Donation couldn't be refused, please try later!")
    });
  }

}
