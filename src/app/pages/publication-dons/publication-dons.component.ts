import { Component, OnInit } from '@angular/core';
import {ExchangeService} from 'src/app/services/exchange.service';

@Component({
  selector: 'app-publication-dons',
  templateUrl: './publication-dons.component.html',
  styleUrls: ['./publication-dons.component.css']
})
export class PublicationDonsComponent implements OnInit {
	idPub: number;

  constructor(private exchange: ExchangeService) {}

  ngOnInit(): void {
  	this.idPub=this.exchange.data.pubId;
  }

}
