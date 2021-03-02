import { Component, OnInit } from '@angular/core';
import { AssociationService } from 'src/app/services/association/association.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.css']
})
export class PublicationComponent implements OnInit {
	titre : String;
	desc : String;
	date : Date;

  constructor(private associationService: AssociationService,private router: Router) { }

  ngOnInit(): void {
  	this.titre="Card title";
  	this.desc="Some quick example text to build on the card title and make up the bulk of the card's content.";
  	this.date=new Date("2019-01-16");
  }


  onSubmit() {
    //this.associationService.
  }

  showDons(){
  	this.router.navigate(["/publication-dons"]);
  }

}
