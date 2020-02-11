import { Component, OnInit } from '@angular/core';
import { AuthService } from 'angularx-social-login';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-head-nav',
  templateUrl: './head-nav.component.html',
  styleUrls: ['./head-nav.component.css']
})
export class HeadNavComponent implements OnInit {
  userData = [];

  constructor(private router: Router, private accountService: AccountService, private authService: AuthService) { }

  ngOnInit() {
  }

  logOut(): void {
    if (!this.userData.length) return
    this.authService.signOut();
    this.userData = [];
    console.log('User has signed our');
  }

}
