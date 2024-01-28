import { Component, OnInit } from '@angular/core';
import { Account } from '../services/account.service';
import { AccountService } from '../services/account.service';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
 
  constructor(private accountService: AccountService) {}
  
  createAccount(): void {
    const accountTypeElement = document.getElementById('accountType') as HTMLInputElement;
    const accountType = accountTypeElement?.value;
  
    const newAccount: Account = {
      accountNumber: '123456789',
      accountType: accountType || 'personal',
      creationDate: new Date(),
      balance: 0,
      owner: 'Nom du propriétaire',
    };
  
    // Ajouter le nouveau compte avec le service
    this.accountService.addAccount(newAccount);
  }

  sideBarVisible: boolean = false; 
 
  signOut() {
    console.log('Déconnexion');
  }
  
   toggleSideBar() {
      this.sideBarVisible = !this.sideBarVisible;
    }
    accounts: Account[] = [];

  ngOnInit(): void {
    this.accounts = this.accountService.getAccounts();
  }

}
