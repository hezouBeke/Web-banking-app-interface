import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
    private accounts: Account[] = [];
  
    getAccounts(): Account[] {
      return this.accounts;
    }
  
    addAccount(account: Account): void {
      this.accounts.push(account);
    }
  }
  
  export interface Account {
    accountNumber: string;
    accountType: string;
    creationDate: Date;
    balance: number;
    owner: string;
  }




