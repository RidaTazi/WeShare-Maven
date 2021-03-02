import { Routes } from '@angular/router';

import { IconsComponent } from '../../pages/icons/icons.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { PublicationComponent } from '../../pages/publication/publication.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { StockComponent } from 'src/app/pages/stock/stock.component';
import { AccueilComponent } from 'src/app/pages/accueil/accueil.component';
import { DonComponent } from 'src/app/pages/don/don.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'user-profile', component: UserProfileComponent },
    { path: 'publication', component: PublicationComponent },
    { path: 'stock', component: StockComponent },
    { path: 'tables', component: TablesComponent },
    { path: 'icons', component: IconsComponent },
    { path: 'accueil', component: AccueilComponent },
    { path: 'don', component: DonComponent },
];