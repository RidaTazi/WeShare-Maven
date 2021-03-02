import { Routes } from '@angular/router';

import { IconsComponent } from '../../pages/icons/icons.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { PublicationComponent } from '../../pages/publication/publication.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { StockComponent } from 'src/app/pages/stock/stock.component';
import { AccueilComponent } from 'src/app/pages/accueil/accueil.component';
import { DonComponent } from 'src/app/pages/don/don.component';
import { RoleGuard } from 'src/app/authentication/guards/role.guard';
import { PublicationDonsComponent } from 'src/app/pages/publication-dons/publication-dons.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'publication', component: PublicationComponent,  canActivate: [RoleGuard], data: { roles: ['A'] } },
    { path: 'stock', component: StockComponent, canActivate: [RoleGuard], data: { roles: ['A'] } },
    { path: 'publication-dons', component: PublicationDonsComponent, canActivate: [RoleGuard], data: { roles: ['A'] } },
    { path: 'accueil', component: AccueilComponent, canActivate: [RoleGuard], data: { roles: ['D'] } },
    { path: 'don', component: DonComponent, canActivate: [RoleGuard], data: { roles: ['D'] } },
    { path: 'user-profile', component: UserProfileComponent},
    { path: 'tables', component: TablesComponent },
    { path: 'icons', component: IconsComponent },
];