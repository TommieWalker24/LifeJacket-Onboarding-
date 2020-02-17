import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, tap, catchError } from 'rxjs/operators';
import { Step } from './models/steps.models';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  constructor(private http: HttpClient) { }

  private serviceUrl = 'api/steps';

  addStep(data: Step) {
    return this.http.post<Step>(this.serviceUrl, data).pipe(
      map(result => { return result })
    );
  }

  getSteps(): Observable<Step[]> {
    return this.http.get<Step[]>(this.serviceUrl)
      .pipe(
        catchError(this.handleError<Step[]>('getSteps', []))
      );
  }
}
