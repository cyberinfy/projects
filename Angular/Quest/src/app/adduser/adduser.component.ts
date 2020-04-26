import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdduserService } from './adduser.service';
import { User } from '../Model/user';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  users: any;
  adminEmployeeid: number;
  constructor(private _router: Router, private _adduserService: AdduserService) { }

  ngOnInit() {
      if (sessionStorage.getItem('valid') === 'true') {
        // tslint:disable-next-line:radix
        this.adminEmployeeid = parseInt(sessionStorage.getItem('employeeid'));
         this.retrieveAll();
      } else {
        this._router.navigateByUrl('/login');
    }
  }

  adduser() {
      // tslint:disable-next-line:radix
      const employeeid = parseInt((<HTMLInputElement>document.getElementById('employeeid')).value);
      const name = (<HTMLInputElement>document.getElementById('name')).value;
      const lg = (<HTMLInputElement>document.getElementById('lg')).value;
      const user: User = {
          employeeid: employeeid,
          name: name,
          lg: lg
      };
      this._adduserService.performAdduser(user).subscribe((result) => {
          if (result.toString() === 'success') {
            alert('user added successfully');
              this.retrieveAll();
          } else {
            alert('unable to add user');
          }
      });
  }

  removeuser() {
      // tslint:disable-next-line:radix
      const employeeid = (<HTMLInputElement>document.getElementById('employeeidtoremove')).value;
    this._adduserService.performRetrieveAll().subscribe((result)  => this.users = result);
          this._adduserService.performRemoveuser(employeeid).subscribe((result) => {
          if (result.toString() === 'success') {
            alert('user removed successfully');
              this.retrieveAll();
          } else {
            alert('unable to remove user');
          }
      });
    }

  retrieveAll() {
    this._adduserService.performRetrieveAll().subscribe((result)  => this.users = result);
  }

}

