import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const users = [
      { email: "brayden.robbins@ruralsourcing.com", password: 'test' },
      { email: "braydenrobbins98@gmail.com", password: 'test1' },
      { email: "test@gmail.com", password: 'test2' },
      { email: "nottest@ruralsourcing.com", password: 'test3' },
    ];
    return { users };
  }
  constructor() { }
}
