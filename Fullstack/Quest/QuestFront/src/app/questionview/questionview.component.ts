import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-questionview',
  templateUrl: './questionview.component.html',
  styleUrls: ['./questionview.component.css']
})
export class QuestionviewComponent implements OnInit {

  useremployeeid: number;
  constructor(private _router: Router) { }

  ngOnInit() {
      if (sessionStorage.getItem('access') === 'allow') {
        // tslint:disable-next-line:radix
        this.useremployeeid = parseInt(sessionStorage.getItem('employeeid'));
      } else {
        this._router.navigateByUrl('/access');
    }
  }

}
