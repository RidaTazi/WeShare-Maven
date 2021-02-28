import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TablesComponent } from '../../pages/candidature/tables.component';
import { OffresComponent } from 'src/app/pages/offres/offres.component';
import { CVComponent } from 'src/app/pages/cv/cv.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'tables',         component: TablesComponent },
    { path: 'offres',         component: OffresComponent},
    { path: 'cv',              component: CVComponent}
];
