import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminnavbar',
  templateUrl: './adminnavbar.component.html',
  styleUrls: ['./adminnavbar.component.css']
})
export class AdminnavbarComponent implements OnInit {
  adminEmployeeid: number;
  constructor(private _router: Router) { }

  ngOnInit() {
      if (sessionStorage.getItem('valid') === 'true') {
        // tslint:disable-next-line:radix
        this.adminEmployeeid = parseInt(sessionStorage.getItem('employeeid'));
      }
  }

  gotoLogin() {
    sessionStorage.removeItem('valid');
    sessionStorage.removeItem('employeeid');
    this._router.navigateByUrl('/login');
  }

}
