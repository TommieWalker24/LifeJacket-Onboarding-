import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { User } from './models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  constructor(private http: HttpClient) { }

  private baseUrlLogin = 'api/users';

  // Login(userData) {
  //   return this.http.post<any>(this.baseUrlLogin, userData).pipe(
  //     map(result => {
  //       if (result.message != null) {
  //         console.log('We sent a message to our Controller API. It works');
  //       }
  //       return result;
  //     })
  //   );
  // }

  Login(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrlLogin, user, this.httpOptions).pipe(
      tap((newUser: User) => console.log(`added user w/ id=${newUser.UserId}`)),
      catchError(this.handleError<User>('addUser'))
    );
  }
}