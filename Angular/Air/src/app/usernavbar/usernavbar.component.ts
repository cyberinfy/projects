import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usernavbar',
  templateUrl: './usernavbar.component.html',
  styleUrls: ['./usernavbar.component.css']
})
export class UsernavbarComponent implements OnInit {

    employeeid = '';
  constructor( private _router: Router) {
  }

  ngOnInit() {
      this.employeeid = sessionStorage.getItem('employeeid');
  }
  terminateaccess() {
    sessionStorage.clear();
    this._router.navigateByUrl('/access');
  }
}
