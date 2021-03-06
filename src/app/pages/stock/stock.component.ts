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
	public dons: Don[][]=[[],[],[],[]];
	types:String[] = ["vêtements", "argent", "sang", "benevolat"];
	sizes:String[] = ["17em", "17em", "17em", "17em"];
	status:number[] = [0,0,0,0];
	icons:String[] = ["ni-bold-right", "ni-bold-right", "ni-bold-right", "ni-bold-right"];

  constructor(private exchange: ExchangeService,private associationService: AssociationService) { }

  ngOnInit(): void {
  }

  getDons(i: number){
  	this.associationService.getAcceptedDonsByPubId(this.types[i]).subscribe(res=>{
  		this.dons[i]=res;
  	},err=>{
  		alert("Can't fetch stock donations , please try later!")
  	});
  }

  showOrHide(i: number){
  	if(this.sizes[i]=="5em"){
  		this.sizes[i]="17em";
  		this.icons[i]="ni-bold-right";
  		this.status[i]=0;
  		this.getDons(i);
  		return;
  	}
  	if(this.sizes[i]=="17em"){
  		this.sizes[i]="5em";
  		this.icons[i]="ni-bold-down";
  		this.status[i]=1;
  		this.getDons(i);
  		return;
  	}
  }

}
