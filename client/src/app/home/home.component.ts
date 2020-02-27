import { Component, OnInit } from '@angular/core';
import { AuthService } from 'angularx-social-login';
import { GoogleLoginProvider } from 'angularx-social-login';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { AppState } from './../app.state';
import * as UserActions from './../actions/user.actions';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user: Observable<User[]>
  userData = [];
  resultMessage: string;

  constructor(private router: Router, private accountService: AccountService, private authService: AuthService, private store: Store<AppState>) {
    this.user = store.select('user');
  }

  ngOnInit() {

  }

  logInWithGoogle(platform: string) {
    this.resultMessage = '';
    platform = GoogleLoginProvider.PROVIDER_ID;
    this.authService.signIn(platform).then(
      async (response) => {
        if (response.email.split('@')[1] !== "ruralsourcing.com") return this.resultMessage = "Make sure you use your RSI email.";
        await this.store.dispatch(new UserActions.AddUser({
          UserId: response.id,
          FirstName: response.firstName,
          LastName: response.lastName,
          EmailAddress: response.email,
          PictureUrl: response.photoUrl
        }));
        // await this.accountService.GetUser(response.email).subscribe(
        //   result => {
        //     this.router.navigateByUrl(`/user`);
        //   },
        //   error => {
        //     console.log(error);
        //     this.router.navigateByUrl(`/location`);
        //   }
        // );
        await this.accountService.Login(this.store.select('user').subscribe(
          result => {
            this.router.navigateByUrl(`/user`);
          },
          error => {
            this.resultMessage = 'Routing didn\'t work and that sucks.';
            console.log(error);
          }
        ));
      },
      (error) => {
        console.log(error);
        this.resultMessage = error;
      }
    )
  }

  logOut(): void {
    if (!this.userData.length) return
    this.authService.signOut();
    this.userData = [];
    console.log('User has signed our');
  }

}
