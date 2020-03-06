import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { User } from './../models/user.model';
import { AppState } from './../app.state';
import { Category } from '../models/category.model';

@Component({
  selector: 'app-head-nav',
  templateUrl: './head-nav.component.html',
  styleUrls: ['./head-nav.component.css']
})
export class HeadNavComponent implements OnInit {
  users$: Observable<User>;
  user: User;
  categories$: Observable<Category[]>;
  categories: Category[];
  searchOptions: Category[];
  dropdownShow: boolean;

  constructor(private store: Store<AppState>) {
    this.users$ = store.select('user');
    this.categories$ = store.select('categories');
  }

  ngOnInit() {
    this.handleLoad();
  }

  handleLoad() {
    this.users$.subscribe(result => {
      this.user = result;
    });
    this.categories$.subscribe(results => this.categories = results);
    this.searchOptions = this.categories;
  }

  toggleDropdown() {
    this.dropdownShow = !this.dropdownShow;
  }

  updateSearchOptions(value) {
    this.searchOptions = this.categories.filter(category => category.name.includes(value));
  }
}
