import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

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
