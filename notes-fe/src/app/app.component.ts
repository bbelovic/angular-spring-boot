import { Component, OnInit } from '@angular/core';
import { AuthService } from './shared/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'notes-fe';
  isAuthenticated: boolean = false;

  constructor(public authService: AuthService) {
  }

  async ngOnInit() {
    this.isAuthenticated = await this.authService.isAuthenticated();
    this.authService.$authenticationState.subscribe(
      (isAuthenticated: boolean) => this.isAuthenticated = isAuthenticated
    );
  }
}
