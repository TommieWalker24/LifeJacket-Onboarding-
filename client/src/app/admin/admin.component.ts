import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Category } from '../models/category.model';
import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';

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
    height: '200px'
  }

  constructor(private dataService: DataService, private store: Store<AppState>) {
    this.categories$ = store.select('categories');
  }

  ngOnInit() {
    this.categories$.subscribe(result => {
      this.categories = result;
    });
    this.editorForm = new FormGroup({
      'editor': new FormControl(null),
      'title': new FormControl(null)
    })
  }


  onSubmit() {
    const content = this.editorForm.get('editor').value;
    const title = this.editorForm.get('title').value;
    const data = { title, content, pending: false, complete: false };
    console.log(content);
    // this.dataService.addStep(data).subscribe(
    //   result => {
    //     console.log('success', result);
    //     this.addSuccess = true;
    //   },
    //   error => {
    //     console.log(error);
    //     this.addFailure = true;
    //   }
    // );
  }

  deleteCategory(category) {
    console.log(category)
  }

  deleteInputChange(value, categoryName) {
    value === categoryName ? this.match = true : this.match = false;
  }

  selectCategory(category) {
    this.selectedCategory = category;
  }

  updateCategoryName(originalName, newName) {
    console.log(originalName, newName);
  }

  // addAsset(assetName) {
  //   console.log(assetName);
  // }


}
