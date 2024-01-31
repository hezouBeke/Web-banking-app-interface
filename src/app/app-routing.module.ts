import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AccountManageComponent } from './account-manage/account-manage.component';
import { TransactionsSidenavComponent } from './transactions-sidenav/transactions-sidenav.component';



const routes: Routes = [
  {path:'', redirectTo: 'welcome', pathMatch: 'full' },
  { path: 'navbar', component: NavbarComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'welcome', component: WelcomeComponent },
  {path: 'dashboard', component: DashboardComponent},
  {path: 'account-manage', component: AccountManageComponent},
  { path: 'dashboard', component: DashboardComponent, children: [
    { path: 'transactions-history', component: TransactionsSidenavComponent },
  ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes),
 ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
