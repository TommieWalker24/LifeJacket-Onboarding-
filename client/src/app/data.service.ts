import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map, tap, catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { AppState } from './app.state';
import { Store } from '@ngrx/store';
import * as CategoryActions from './actions/category.actions';
import * as PendingCategoryActions from './actions/pendingCategory.actions';
import * as CurrentCategoryActions from './actions/currentCategory.actions';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient, private store: Store<AppState>) { }

  private serviceUrl = 'http://localhost:8080';

  handleError(operation = 'operation', result) {
    return (error: any) => {
      console.error(error);
      return of(result);
    };
  }

  getCategories() {
    fetch(`${this.serviceUrl}/category/findAll`)
      .then(res => {
        return res.json();
      })
      .then(categories => {
        this.store.dispatch(new CategoryActions.SetCategories(categories));
      })
  }

  getUserPendingCategory(email) {
    fetch(`${this.serviceUrl}/categories/firstPending?email=${email}`)
      .then(res => {
        return res.json();
      })
      .then(pendingCategory => {
        this.store.dispatch(new PendingCategoryActions.SetPendingCategory(pendingCategory));
      })
  }

  getCategoryDetails(email, categoryId) {
    fetch(`${this.serviceUrl}/categories/getUserCategory?email=${email}&categoryId=${categoryId}`)
      .then(res => {
        return res.json();
      })
      .then(currentCategory => {
        this.store.dispatch(new CurrentCategoryActions.SetCurrentCategory(currentCategory));
      })
  }

  getDevCenters() {
    return this.http.get(`${this.serviceUrl}/devCenters`)
      .pipe(
        map(result => { return result }),
        catchError(this.handleError('getDevCenters', []))
      )
  }

  userCompleteStep(stepId, email) {
    return this.http.patch(`${this.serviceUrl}/steps/completeStep`, { email, stepId });
  }

  addStep(data) {
    return this.http.post(this.serviceUrl, { data })
      .pipe(
        map(result => result),
        catchError(this.handleError('addStep', []))
      );
  }

  deleteStep(title) {
    return this.http.delete(`${this.serviceUrl}/steps/delete/${title}`)
      .pipe(
        map(result => result),
        catchError(this.handleError('deleteStep', []))
      );
  }

  addCategory(categoryName) {
    return this.http.post(this.serviceUrl, { categoryName })
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
