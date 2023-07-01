import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ViewClubsComponent } from './pages/view-clubs/view-clubs.component';
import { AddClubComponent } from './pages/add-club/add-club.component';
import { DeleteClubComponent } from './pages/delete-club/delete-club.component';
import { UpdateClubComponent } from './pages/update-club/update-club.component';

// Path is the routerLink property given inside the element
const routes: Routes = [
  { path: "home", component: HomePageComponent },
  { path: "add-club", component: AddClubComponent },
  { path: "view-club", component: ViewClubsComponent },
  { path: "update-club", component: UpdateClubComponent },
  { path: "delete-club", component: DeleteClubComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
