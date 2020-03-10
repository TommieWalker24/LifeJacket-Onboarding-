import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Category } from '../models/category.model';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import * as CategoryActions from '../actions/category.actions';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  categories$: Observable<Category[]>;
  categories: Category[];
  selectedCategory: string;
  editorForm: FormGroup;
  match: boolean = false;

  editorStyle = {
    height: '300px'
  }

  constructor(private dataService: DataService, private store: Store<AppState>) {
    this.categories$ = store.select('categories');
  }

  ngOnInit() {
    this.categories$.subscribe(result => {
      if (!result) {
        this.dataService.getCategories()
          .subscribe(categories => {
            this.store.dispatch(new CategoryActions.SetCategories(categories));
            this.categories = categories;
          })
      }
    });
    this.editorForm = new FormGroup({
      'editor': new FormControl(null),
      'title': new FormControl(null)
    });
  }

  addStep() {
    const content = this.editorForm.get('editor').value;
    const title = this.editorForm.get('title').value;
    const data = { title, category: this.selectedCategory, content };
    this.dataService.addStep(data)
      .subscribe(
        result => {
          console.log('success', result);
        },
        error => {
          console.log(error);
        }
      );
  }

  addCategory(categoryName) {
    this.dataService.addCategory(categoryName);
  }

  deleteCategory(category) {
    this.dataService.deleteCategory(category);
  }

  deleteInputChange(value, categoryName) {
    value === categoryName ? this.match = true : this.match = false;
  }

  selectCategory(category) {
    this.selectedCategory = category;
  }

  updateCategoryName(originalName, newName) {
    this.dataService.editCategoryName(originalName, newName);
  }

}
