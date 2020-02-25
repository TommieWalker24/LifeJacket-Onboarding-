import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, tap, catchError } from 'rxjs/operators';
import { Step } from './models/steps.models';
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

  addStep(data: Step) {
    return this.http.post<Step>(this.serviceUrl, data).pipe(
      map(result => { return result })
    );
  }

  getSteps() {
    return this.http.get(`${this.serviceUrl}/steps`)
      .pipe(
        catchError(this.handleError('getSteps', []))
      );
  }

  getDevCenters() {
    return this.http.get(`${this.serviceUrl}/devCenters`)
      .pipe(
        map(result => { return result }),
        catchError(this.handleError('getDevCenters', []))
      )
  }
}
