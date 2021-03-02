import { Component, OnInit } from '@angular/core';
import { AssociationService } from 'src/app/services/association/association.service';

@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.css']
})
export class PublicationComponent implements OnInit {

  constructor(private associationService: AssociationService) { }

  ngOnInit(): void {

  }


  onSubmit() {
    //this.associationService.
  }

}
