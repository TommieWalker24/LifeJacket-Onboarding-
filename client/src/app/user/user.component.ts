import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { User } from './../models/user.model';
import { AppState } from './../app.state';
import { DataService } from '../data.service';
import { Step } from '../models/steps.models';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: Observable<User[]>;
  steps: Observable<Step[]>;
  stepProgress: number;

  constructor(private store: Store<AppState>, private dataService: DataService) {
    this.users = store.select('user');
    this.steps = store.select('steps');
  }

  ngOnInit() {
    // this.dataService.getSteps();
    this.steps.subscribe(results => {
      this.stepProgress = (results.filter(step => step.complete === true).length / results.length) * 100;
      console.log(this.stepProgress);
    })
  }
}
