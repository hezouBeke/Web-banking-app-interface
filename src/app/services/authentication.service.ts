
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private apiUrl = 'URL_DE_VOTRE_API';

  constructor(private http: HttpClient) {}

  loginUser(email: string, password: string) {
    const body = { email, password };
    return this.http.post(`${this.apiUrl}/login`, body);
  }
}
