import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms'
import { DonneurService } from 'src/app/services/donneur/donneur.service';
import { Don } from 'src/app/models/don';

@Component({
  selector: 'app-don',
  templateUrl: './don.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['./don.component.css']
})
export class DonComponent implements OnInit {

  closeResult: string;
  types:String[] = ["vêtements", "argent", "sang", "benevolat"];
  public dons:Don[] = [];

  constructor(private modalService: NgbModal,private donneurService: DonneurService) {}

  openBackDropCustomClass(content) {
    this.modalService.open(content, {backdropClass: 'light-blue-backdrop'});
  }

  openWindowCustomClass(content) {
    this.modalService.open(content, { windowClass: 'dark-modal' });
  }

  openXl(content) {
    this.modalService.open(content, { size: 'xl',centered: true, windowClass: 'dark-modal',backdropClass: 'light-blue-backdrop' });
  }

  onSubmit(DonForm: NgForm) {

    if (!DonForm.valid) {
      return;
    }

    const type = DonForm.value.type;
    const description = DonForm.value.description;
    const image = DonForm.value.image;

    const body = {
      typeDon : type,
      logoDon : image,
      descDon : description,
      stateDon : "attente"
    }

    this.donneurService.addDon(body).subscribe(response => {
      if(response == 0)
      {
        this.donneurService.getUserDons().subscribe(response => {
          console.log(response);
          this.dons = response;
        },err => console.log(err));
        DonForm.reset();
        this.modalService.dismissAll();
      }

    });
  }

  onUpdateSubmit(updateForm: NgForm,index){
    if (!updateForm.valid) {
      return;
    }

    const body = {
      idDon : this.dons[index].iD,
      typeDon : this.dons[index].type,
      logoDon : this.dons[index].logo,
      descDon : this.dons[index].desc,
      dateDon : this.dons[index].date,
      stateDon :  this.dons[index].state,
      etatInfo : this.dons[index].etatInfo,
    }

    this.donneurService.updateDon(body).subscribe(response => {
      if(response == 0)
      {
        this.donneurService.getUserDons().subscribe(response => {
          console.log(response);
          this.dons = response;
        },err => console.log(err));
        this.modalService.dismissAll();
      }


    });

  }

  ngOnInit(){
    this.donneurService.getUserDons().subscribe(response => {
      console.log(response);
      this.dons = response;
    },err => console.log(err));
  }

  deleteDon(index){
    this.donneurService.deleteDon(this.dons[index].iD).subscribe(res => {
      console.log("delete : " + res);
      if(res==1)
      {
        this.dons.splice(index,index++);
      }
    },err => console.log(err));

  }

  updateTemplate(don_index,content){
    const ref = this.modalService.open(content, { size: 'xl',centered: true, windowClass: 'dark-modal',backdropClass: 'light-blue-backdrop' });
  }

  updateDon(index){
    this.donneurService.updateDon(this.dons[index]).subscribe(res => {
      console.log("update : " + res);
    },err => console.log(err))
  }

}


