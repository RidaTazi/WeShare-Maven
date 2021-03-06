import { Component, OnInit } from '@angular/core';
import { DonneurService } from 'src/app/services/donneur/donneur.service';
import {Publication} from 'src/app/models/publication';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/authentication/services/auth.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
	public pubs: Publication[]=[];
	types:String[] = ["vêtements", "argent", "sang", "benevolat"];
	pubId: number;

  constructor(private authService: AuthService,private donneurService: DonneurService,private modalService: NgbModal) { }

  ngOnInit(): void {
  	this.donneurService.getAllPubs().subscribe(response=>{
  		this.pubs=response;
  	},err=>{
  		alert("Server Problem, kindly try later!")
  	})
  }

  openXl(content) {
    this.modalService.open(content, { size: 'xl',centered: true, windowClass: 'dark-modal',backdropClass: 'light-blue-backdrop' });
  }


  donnate(id: number,content){
  	this.openXl(content);
  	this.pubId=id;
  	console.log(id);
  }


  onSubmit(DonForm: NgForm) {

    if (!DonForm.valid) {
      return;
    }
    const body = {
      type : DonForm.value.type,
      desc : DonForm.value.description,
      idDonneur: this.authService.userId
    }

    this.donneurService.donnate(this.pubId,body).subscribe(response => {
      DonForm.reset();
      this.modalService.dismissAll();
    });
  }
}