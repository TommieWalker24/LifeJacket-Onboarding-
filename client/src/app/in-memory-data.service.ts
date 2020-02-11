import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const users = [
      { EmailAddress: "brayden.robbins@ruralsourcing.com", UserId: 1234, FirstName: "Brayden", LastName: "Robbins", PictureUrl: 'http://google.com', Provider: 'Google' },
      { EmailAddress: "braydenrobbins98@gmail.com", password: 'test1' },
      { EmailAddress: "test@gmail.com", password: 'test2' },
      { EmailAddress: "nottest@ruralsourcing.com", password: 'test3' },
    ];
    return { users };
  }
  constructor() { }
}
