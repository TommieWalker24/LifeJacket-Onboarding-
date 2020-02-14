import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  private serviceUrl = 'http://localhost/5000/step';

  AddStep(data) {
    return this.http.post<any>(this.serviceUrl, data).pipe(
      map(result => {
        if (result.message != null) {
          console.log('We sent a message to our Controller API. It works');
        }
        return result;
      })
    );
  }
}
