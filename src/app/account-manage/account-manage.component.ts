import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-manage',
  templateUrl: './account-manage.component.html',
  styleUrls: ['./account-manage.component.css']
})
export class AccountManageComponent implements OnInit {
ngOnInit(): void {
  throw new Error('Method not implemented.');
}
signOut() {
  console.log('Déconnexion');
}
}
