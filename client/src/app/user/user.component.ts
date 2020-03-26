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
  categories$: Observable<Category[]>;
  categories: Category[];
  pendingCategory$: Observable<Object>;
  pendingCategory: Object;
  stepProgress: number;

  constructor(private store: Store<AppState>, private dataService: DataService, private accountService: AccountService) {
    this.users$ = store.select('user');
    this.categories$ = store.select('categories');
    this.pendingCategory$ = store.select('pendingCategory');
  }

  ngOnInit() {
    this.users$.subscribe(result => this.user = result);
    if (!this.user) this.accountService.Refresh();
    this.categories$.subscribe(results => this.categories = results);
    if (!this.categories) this.dataService.getCategories();
    this.pendingCategory$.subscribe(results => this.pendingCategory = results);
    // if (!this.pendingCategory) this.dataService.getUserPendingCategory(this.user.EmailAddress);

    console.log(this.user);
    console.log(this.categories);
  }
}
