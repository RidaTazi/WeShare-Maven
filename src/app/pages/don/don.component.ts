import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms'
import { DonneurService } from 'src/app/services/donneur/donneur.service';

@Component({
  selector: 'app-don',
  templateUrl: './don.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['./don.component.css']
})
export class DonComponent implements OnInit {

  closeResult: string;
  types:String[] = ["vêtements", "argent", "sang", "benevolat"];
  dons;

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
      DonForm.reset();
      this.modalService.dismissAll();
    });



  }

  ngOnInit(){
    this.donneurService.getUserDons().subscribe(response => {
      console.log(response);
      this.dons = response;
    },err => console.log(err));
  }

}

interface Don {
  association,
  date,
  desc,
  donneur,
  etatInfo,
  iD,
  logo,
  publication,
  state,
  type
}
