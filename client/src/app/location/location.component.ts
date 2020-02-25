import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { DevCenter } from '../models/devCenter.model';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';
import { AppState } from '../app.state';
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {

  devCenters: DevCenter[];
  selected: string;

  constructor(private dataService: DataService, private accountService: AccountService, private router: Router, private store: Store<AppState>) { }

  ngOnInit() {
    this.getDevCenters();
  }

  getDevCenters(): void {
    this.dataService.getDevCenters()
      .subscribe(devCenters => this.devCenters = devCenters);
  }

  setSelected(userInput) {
    this.selected = userInput;
  }

  login() {
    this.store.select('user').subscribe(
      result => {
        const user = result[0];
        user.Location = this.selected;
        this.accountService.Login(user).subscribe(result => {
          console.log(result);
        })
      }
    );
  }


}
