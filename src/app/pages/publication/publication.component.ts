import { Component, OnInit } from '@angular/core';
import { AssociationService } from 'src/app/services/association/association.service';
import {Router} from '@angular/router';
import { Observable } from 'rxjs';
import {Publication} from 'src/app/models/publication';
import {ExchangeService} from 'src/app/services/exchange.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/authentication/services/auth.service';


@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.css']
})
export class PublicationComponent implements OnInit {
	public pubs: Publication[]=[]; 
  pubId: number;

  constructor(private modalService: NgbModal,private associationService: AssociationService,private router: Router, private exchange: ExchangeService) { }

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
      alert("This Pub couldn't be deleted, please try later!")
    });
  }
 
  openXl(content) {
    this.modalService.open(content, { size: 'xl',centered: true, windowClass: 'dark-modal',backdropClass: 'light-blue-backdrop' });
  }

  updatePub(id: number,content){
    this.openXl(content);
    this.pubId=id;
    console.log(id);
  }

  onSubmit(DonForm: NgForm) {

    if (!DonForm.valid) {
      return;
    }
    const body = {
      titrePub : DonForm.value.titre,
      descPub : DonForm.value.description,
      idPub: this.pubId,
    }

    this.associationService.updatePubById(this.pubId,body).subscribe(response => {
      DonForm.reset();
      this.modalService.dismissAll();
    });
    this.ngOnInit();
  }

  addPub(content){
    console.log("add");
  }
}
