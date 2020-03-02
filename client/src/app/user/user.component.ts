import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { User } from './../models/user.model';
import { AppState } from './../app.state';
import { DataService } from '../data.service';
import { Category } from '../models/category.model';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users$: Observable<User>;
  user: User;
  stepProgress: number;
  categories$: Observable<Category[]>;
  categories: Category[];

  constructor(private store: Store<AppState>, private dataService: DataService, private accountService: AccountService) {
    this.users$ = store.select('user');
    this.categories$ = store.select('categories');
  }

  ngOnInit() {
    this.users$.subscribe(result => {
      this.user = result;
    });
    if (!this.user) {
      console.log('We tried to refresh the user');
      this.accountService.Refresh();
    }
    console.log("We tried to fetch the user categories");
    // this.dataService.getCategories(this.user.EmailAddress);
    this.categories$.subscribe(results => {
      this.categories = results;
    });
  }

  handleClick() {
    console.log('here');
  }
}
