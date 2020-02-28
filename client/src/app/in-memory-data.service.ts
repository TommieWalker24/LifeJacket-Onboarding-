import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const devCenters = [
      { devCenter: 'Oklahoma City' },
      { devCenter: 'Mobile' },
      { devCenter: 'Jonesboro' },
      { devCenter: 'Augusta' },
      { devCenter: 'Fort Wayne' },
      { devCenter: 'Albuquerque' }
    ]
    const users = [
      { EmailAddress: "brayden.robbins@ruralsourcing.com" },
      { EmailAddress: "braydenrobbins98@gmail.com", password: 'test1' },
      { EmailAddress: "test@gmail.com", password: 'test2' },
      { EmailAddress: "nottest@ruralsourcing.com", password: 'test3' },
    ];
    const steps = [
      {
        name: "Step1",
        complete: true,
        pending: false,
        description: "steeeep 11"
      },
      {
        name: "Step2",
        complete: true,
        pending: false,
        description: "steeeep 22"
      },
      {
        name: "Step3",
        complete: false,
        pending: true,
        description: "steeeep 33"
      },
      {
        name: "Step4",
        complete: false,
        pending: false,
        description: "steeeep 44"
      },
      {
        name: "Step5",
        complete: false,
        pending: false,
        description: "steeeep 55"
      }]
    return { users, steps, devCenters };
  }
  constructor() { }
}
