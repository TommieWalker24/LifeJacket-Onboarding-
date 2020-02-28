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
  private baseUrlLogin = 'api/users';
  //communicate with web api
  Login(userData) {
    return this.http.post<any>(this.baseUrlLogin, userData).pipe(
      map(result => {
        if (result.message != null) {
          console.log('We sent a message to our Controller API. It works');
        }
        return result;
      })
    );
  }

  Refresh() {
    return this.http.get(`${this.baseUrlLogin}/refresh`).pipe(
      map(res => {
        // this.store.dispatch(new UserActions.AddUser(res));
      })
    );
  }

  CheckUserExist(email) {
    return this.http.get(`${this.baseUrlLogin}/${email}`).pipe(
      map(res => {
        return res;
      })
    );
  }
}