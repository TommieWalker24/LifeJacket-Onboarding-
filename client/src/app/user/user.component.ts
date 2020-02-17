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

  constructor(private store: Store<AppState>, private dataService: DataService) {
    this.users = store.select('user');
    this.steps = store.select('steps');
    console.log(this.steps)
  }

  ngOnInit() {
    this.dataService.getSteps();
  }
}
