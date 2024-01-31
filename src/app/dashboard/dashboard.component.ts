import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { Account } from '../services/account.service';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  public noTransactions: boolean;
  public transactions: any[] = [];

  isTransactionsHistoryPage: boolean = false;
  successMessage: string = '';
  sideBarVisible: boolean = false;
  sideBarVisible_t: boolean = false;
  accounts: Account[] = [];
  selectedTransactionType: string = '';
  setTransactionsHistoryPage(isTransactionsHistoryPage: boolean): void {
    this.isTransactionsHistoryPage = isTransactionsHistoryPage;
  }


  constructor(private cdr: ChangeDetectorRef, private accountService: AccountService) {
    this.cdr = cdr;
    this.noTransactions = this.transactions.length === 0;
  }

  createAccount(): void {
    const accountTypeElement = document.getElementById('accountType') as HTMLInputElement;
    const accountType = accountTypeElement?.value;

    const newAccount: Account = {
      accountNumber: '123456789',
      accountType: accountType || 'PERSONAL',
      creationDate: new Date(),
      balance: 0,
      owner: 'Nom du propriétaire',
    };

    this.accountService.addAccount(newAccount);
    this.sideBarVisible = false;
    this.successMessage = 'Compte créé avec succès !';

    setTimeout(() => {
      this.successMessage = '';
    }, 1000);
  }

  signOut() {
    console.log('Déconnexion');
  }

  toggleSideBar() {
    this.sideBarVisible = !this.sideBarVisible;
  }

  toggleSideBar_t() {
    this.sideBarVisible_t = !this.sideBarVisible_t;
  }

  ngOnInit(): void {
    this.accounts = this.accountService.getAccounts();
  }

  toggleDropdown(event: Event) {
    const dropdownContent = (event.target as HTMLElement).nextElementSibling;
    if (dropdownContent) {
      dropdownContent.classList.toggle('active');
    }
  }


  onTransactionTypeChange(event: any) {
    this.selectedTransactionType = event.target.value;
    this.cdr.detectChanges();
  }
 
}
