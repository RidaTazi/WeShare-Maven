import { Component, OnInit } from '@angular/core';
import {ExchangeService} from 'src/app/services/exchange.service';
import { AssociationService } from 'src/app/services/association/association.service';
import {Don} from 'src/app/models/don';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
	public dons: Don[]=[];

  constructor(private exchange: ExchangeService,private associationService: AssociationService) { }

  ngOnInit(): void {
  	this.associationService.getAcceptedDonsByPubId().subscribe(res=>{
  		this.dons=res;
  		console.log(this.dons);
  	},err=>{
  		alert("Can't fetch stock donations , please try later!")
  	});
  	console.log("stock")
  }

}
