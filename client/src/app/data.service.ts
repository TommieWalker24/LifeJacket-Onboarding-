import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, tap, catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private handleError(operation = 'operation', result) {
    return (error: any) => {
      console.error(error);
      return of(result);
    };
  }

  constructor(private http: HttpClient) { }

  private serviceUrl = 'api';

  addStep(data) {
    return this.http.post(this.serviceUrl, data).pipe(
      map(result => result)
    );
  }

  getCategories(email) {
    console.log(email);
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

  deleteCategory(categoryId) {
    return this.http.delete(`${this.serviceUrl}/categories/delete/${categoryId}`)
      .pipe(
        map(result => result),
        catchError(this.handleError('deleteCategory', []))
      )
  }

  editCategoryName(categoryId, newName) {
    return this.http.patch(`${this.serviceUrl}/categories/edit`, { categoryId, newName })
      .pipe(
        map(result => result),
        catchError(this.handleError('deleteCategory', []))
      )
  }
}
