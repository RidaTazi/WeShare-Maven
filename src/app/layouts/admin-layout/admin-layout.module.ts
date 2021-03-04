import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ClipboardModule } from 'ngx-clipboard';

import { AdminLayoutRoutes } from './admin-layout.routing';
import { IconsComponent } from '../../pages/icons/icons.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PublicationComponent } from 'src/app/pages/publication/publication.component';
import { DonComponent } from 'src/app/pages/don/don.component';
import { AccueilComponent } from 'src/app/pages/accueil/accueil.component';
import { StockComponent } from 'src/app/pages/stock/stock.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    HttpClientModule,
    NgbModule,
    ClipboardModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    UserProfileComponent,
    PublicationComponent,
    DonComponent,
    AccueilComponent,
    StockComponent,
    TablesComponent,
    IconsComponent,
  ]
})

export class AdminLayoutModule {}
