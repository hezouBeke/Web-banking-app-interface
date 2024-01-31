import { Component } from '@angular/core';

@Component({
  selector: 'app-transactions-sidenav',
  templateUrl: './transactions-sidenav.component.html',
  styleUrls: ['./transactions-sidenav.component.css']
})

export class TransactionsSidenavComponent {
  noTransactions: boolean = true; // Définir la valeur par défaut selon la logique de votre application
}