import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminsearch',
  templateUrl: './adminsearch.component.html',
  styleUrls: ['./adminsearch.component.css']
})
export class AdminsearchComponent implements OnInit {

  adminEmployeeid: number;
  constructor(private _router: Router) { }

  ngOnInit() {
      if (sessionStorage.getItem('valid') === 'true') {
        // tslint:disable-next-line:radix
        this.adminEmployeeid = parseInt(sessionStorage.getItem('employeeid'));
      } else {
        this._router.navigateByUrl('/login');
    }
  }

}


