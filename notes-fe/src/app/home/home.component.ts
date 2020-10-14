import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isAuthenticated: boolean = false;

  constructor(public auth: AuthService) {
  }

  async ngOnInit() {
    this.isAuthenticated = await this.auth.isAuthenticated();
    // Subscribe to authentication state changes
    this.auth.$authenticationState.subscribe(
      (isAuthenticated: boolean)  => this.isAuthenticated = isAuthenticated
    );
  }
}
