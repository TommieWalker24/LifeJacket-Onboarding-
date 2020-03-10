import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map, tap, catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { AppState } from './app.state';
import { Store } from '@ngrx/store';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  // private serviceUrl = 'http://localhost:8080';
  private serviceUrl = 'api'

  handleError(operation = 'operation', result) {
    return (error: any) => {
      console.error(error);
      return of(result);
    };
  }

  getCategories() {
    return this.http.get(`${this.serviceUrl}/categories`)
      .pipe(
        map(result => result),
        catchError(this.handleError('getCategories', []))
      );
  }

  getUserPendingCategory(email) {
    return this.http.get(`${this.serviceUrl}/categories/firstPending?email=${email}`)
      .pipe(
        map(result => result),
        catchError(this.handleError('getiUserPendingCategories', []))
      );
  }

  getCategoryDetails(email, categoryId) {
    return this.http.get(`${this.serviceUrl}/categories/getUserCategory?email=${email}&categoryId=${categoryId}`)
      .pipe(
        map(result => result),
        catchError(this.handleError('getiUserPendingCategories', []))
      );
  }

  getDevCenters() {
    return this.http.get(`${this.serviceUrl}/devCenters`)
      .pipe(
        map(result => { return result }),
        catchError(this.handleError('getDevCenters', []))
      )
  }

  userCompleteStep(step, email) {
    return this.http.patch(`${this.serviceUrl}/user`, { email, step });
  }

  addStep(data) {
    console.log(data);
    return this.http.post(this.serviceUrl, data)
      .pipe(
        map(result => result),
        catchError(this.handleError('addStep', []))
      );
  }

  addCategory(categoryName) {
    return this.http.post(this.serviceUrl, categoryName)
      .pipe(
        map(result => result),
        catchError(this.handleError('addCategory', []))
      );
  }

  editCategoryName(categoryId, newName) {
    return this.http.patch(`${this.serviceUrl}/categories/edit`, { categoryId, newName })
      .pipe(
        map(result => result),
        catchError(this.handleError('editCategoryName', []))
      )
  }

  deleteCategory(categoryId) {
    return this.http.delete(`${this.serviceUrl}/categories/delete/${categoryId}`)
      .pipe(
        map(result => result),
        catchError(this.handleError('deleteCategory', []))
      )
  }
}
