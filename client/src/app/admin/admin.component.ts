import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private adminService: AdminService) { }

  addSuccess: boolean = false;
  addFailure: boolean = false;

  ngOnInit() {
  }

  hideAlert() {
    this.addFailure = false;
    this.addSuccess = false;
  }

  addStep(title: string, url: string, description: string): void {
    const data = { title, url, description }
    this.adminService.AddStep(data).subscribe(
      result => {
        console.log('success', result);
        this.addSuccess = true;
      },
      error => {
        console.log(error);
        this.addFailure = true;
      }
    );
  }

}
