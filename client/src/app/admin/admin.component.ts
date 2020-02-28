import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  addSuccess: boolean = false;
  addFailure: boolean = false;
  editorForm: FormGroup;

  editorStyle = {
    height: '200px'
  }

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.editorForm = new FormGroup({
      'editor': new FormControl(null),
      'title': new FormControl(null)
    })
  }

  hideAlert() {
    this.addFailure = false;
    this.addSuccess = false;
  }

  onSubmit() {
    const content = this.editorForm.get('editor').value;
    const title = this.editorForm.get('title').value;
    const data = { title, content, pending: false, complete: false }
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

  addAsset(assetName) {
    console.log(assetName);
  }


}
