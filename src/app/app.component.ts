import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private router: Router) {}

  loader = true;
  ngOnInit(): void {
    setTimeout(() => {
      this.loader = false;
     
    }, 4000);
  }

  title = 'EGA_BANK';
}
