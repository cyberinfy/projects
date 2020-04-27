import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

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
