import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const categories = [
      {
        name: 'category 1',
        sequenceNumber: 1,
        pending: false,
        complete: true,
        steps: [
          {
            title: 'category 1 step 1',
            content: '<p><em>This is some text that will be html and it\'s gonna have a video.</em></p><p><em>sdfghfgd</em></p><p><em>dfghdfgj</em></p><p><em>fghjk</em></p><p><em>hg</em><strong><em>kghjkl</em></strong></p><p><strong><em>ghjk</em></strong></p><p><strong><em>f</em></strong></p><p><strong>srg</strong></p><p><br></p><p><s>rt</s></p><p><br></p><p><br></p>',
            complete: true
          },
          {
            title: 'category 1 step 2',
            content: '<p>malicious content</p><script>console.log(\'attack!\'</script>',
            complete: true
          },
          {
            title: 'category 1 step 3',
            content: 'category 1 step 3 content',
            complete: true
          }
        ]
      },
      {
        name: 'category 2',
        sequenceNumber: 2,
        pending: true,
        complete: false,
        steps: [
          {
            title: 'category 2 step 1',
            content: 'category 2 step 1 content',
            complete: true
          },
          {
            title: 'category 2 step 2',
            content: 'category 2 step 2 content',
            complete: false
          },
          {
            title: 'category 2 step 3',
            content: 'category 2 step 3 content',
            complete: false
          }
        ]
      },
      {
        name: 'category 3',
        sequenceNumber: 3,
        pending: false,
        complete: false,
        steps: [
          {
            title: 'category 3 step 1',
            content: 'category 3 step 1 content',
            complete: false
          },
          {
            title: 'category 3 step 2',
            content: 'category 3 step 2 content',
            complete: false
          },
          {
            title: 'category 3 step 3',
            content: 'category 3 step 3 content',
            complete: false
          }
        ]
      }
    ];
    const devCenters = [
      { devCenter: 'Oklahoma City' },
      { devCenter: 'Mobile' },
      { devCenter: 'Jonesboro' },
      { devCenter: 'Augusta' },
      { devCenter: 'Fort Wayne' },
      { devCenter: 'Albuquerque' }
    ];
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
      }];
    return { users, steps, devCenters, categories };
  }
  constructor() { }
}
