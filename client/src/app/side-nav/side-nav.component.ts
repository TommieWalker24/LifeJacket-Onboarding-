import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/category.model';
import { AppState } from '../app.state';
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent implements OnInit {
  categories$: Observable<Category[]>;
  categories: Array<{}>;

  constructor(private store: Store<AppState>) {
    this.categories$ = store.select('categories');
  }

  ngOnInit() {
    this.categories$.subscribe(results => {
      this.categories = results;
    })
  }

}
