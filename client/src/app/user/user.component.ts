import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { User } from './../models/user.model';
import { AppState } from './../app.state';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  steps = [
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
  users: Observable<User[]>;

  constructor(private store: Store<AppState>) {
    this.users = store.select('user')
  }

  ngOnInit() {
  }

}
