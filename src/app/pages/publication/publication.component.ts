import { Component, OnInit } from '@angular/core';
import { AssociationService } from 'src/app/services/association/association.service';
import {Router} from '@angular/router';
import { Observable } from 'rxjs';
import {Publication} from 'src/app/models/publication';


@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.css']
})
export class PublicationComponent implements OnInit {
	public pubs: Publication[]=[]; 
	public idClicked : number=-1;
  constructor(private associationService: AssociationService,private router: Router) { }

  ngOnInit(): void {
  	this.associationService.getPubsByAssocId().subscribe(response=>{
  		this.pubs=response;
  	},err=>{
  		alert("Server Problem !")
  	})
  }

  showDons(){
  	// this.router.navigate(["/publication-dons"]);
  	console.log(this.idClicked[0]);

  }


}
