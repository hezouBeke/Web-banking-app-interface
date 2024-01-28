import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navigate-bar',
  templateUrl: './navigate-bar.component.html',
  styleUrls: ['./navigate-bar.component.css']
})
export class NavigateBarComponent implements OnInit {
   
ngOnInit() : void {

}
signOut() {
  console.log('Déconnexion');
}

}
