import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
    setTimeout(() => {
      this.loader = false;
    }, 3000);
  }
  title = 'frontend';
  loader = true;

}
