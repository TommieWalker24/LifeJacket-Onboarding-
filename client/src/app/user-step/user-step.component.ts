import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { User } from './../models/user.model';
import { AppState } from './../app.state';
import { DataService } from '../data.service';
import { Category } from '../models/category.model';
import { AccountService } from '../account.service';
import { Step } from '../models/step.model';
import { ActivatedRoute } from '@angular/router';
import { Router, NavigationEnd } from '@angular/router';


@Component({
  selector: 'app-user-step',
  templateUrl: './user-step.component.html',
  styleUrls: ['./user-step.component.css']
})
export class UserStepComponent implements OnInit {
  users$: Observable<User>;
  user: User;
  stepProgress: number;
  categories$: Observable<Category[]>;
  categories: Category[];
  currentCategory$: Observable<Category>;
  currentCategory: Category;

  constructor(private store: Store<AppState>, private dataService: DataService, private accountService: AccountService, private activeRoute: ActivatedRoute, private route: Router) {
    this.users$ = store.select('user');
    this.categories$ = store.select('categories');
    this.currentCategory$ = store.select('currentCategory');
    this.routeEvent(this.route);
  }

  ngOnInit() {
    this.handleLoad();
  }

  routeEvent(router: Router) {
    router.events.subscribe(e => {
      if (e instanceof NavigationEnd) {
        this.handleLoad();
      }
    });
  }

  handleLoad() {
    this.users$.subscribe(result => this.user = result);
    if (!this.user) this.accountService.Refresh();
    this.categories$.subscribe(results => this.categories = results);
    if (!this.categories) this.dataService.getCategories();

    this.currentCategory$.subscribe(results => this.currentCategory = results);
    if (!this.currentCategory) {
      const urlParams = this.activeRoute.snapshot.paramMap.get('category');
      const currentCategoryId = this.categories.filter(category => category.category === urlParams);
      this.dataService.getCategoryDetails(this.user.EmailAddress, currentCategoryId);
    }

    let stepsArray = [];
    const steps = this.categories.map(category => category.steps.map(step => stepsArray.push(step)));
    this.stepProgress = Math.floor((stepsArray.filter(step => step.complete === true).length / stepsArray.length) * 100);
  }

  completeStep(stepTitle) {
    this.dataService.userCompleteStep(stepTitle, this.user.EmailAddress);
  }

}
