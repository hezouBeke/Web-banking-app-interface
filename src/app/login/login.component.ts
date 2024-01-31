import { Component } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email: string = '';
  password: string = '';
 
  constructor(private authenticationService: AuthenticationService, private router: Router) {}
  onSubmit() {
    console.log('Email:', this.email);
    console.log('Password:', this.password);
    
    this.authenticationService.loginUser(this.email, this.password).subscribe(
      (response) => {
        console.log('Connexion réussie :', response);
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        console.error('Erreur de connexion :', error);
      }
    );
  }
}
