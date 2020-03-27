import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { AppState } from './app.state';
import { Store } from '@ngrx/store';
import * as UserActions from './actions/user.actions';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  constructor(private http: HttpClient, private store: Store<AppState>) { }
  //properties needed
  private baseUrlLogin = 'https://localhost:44375/api';
  //communicate with web api
  Login(userData) {
    console.log('here');
    // fetch(`${this.baseUrlLogin}`, {
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json'
    //   },
    //   body: JSON.stringify(userData)
    // })
    //   .then(res => {
    //     return res.json();
    //   })
    //   .then(user => {
    //     console.log(user);
    //   })
    //   .catch(error => {
    //     console.error(error);
    //   })
  }

  Refresh() {
    return this.http.get(`${this.baseUrlLogin}/refresh`).pipe(
      map(res => {
        // this.store.dispatch(new UserActions.AddUser(res));
      })
    );
  }

  // CheckUserExist(email) {
  //   fetch(`${this.baseUrlLogin}`, {
  //     method: 'POST', 
  //     headers: {
  //       'Content-Type': 'application/json'
  //     },
  //     body: JSON.stringify(email)
  //   })
  //     .then(res => {
  //       return res.json();
  //     })
  //     .then(user => {
  //       console.log(user);
  //     })
  // }
}