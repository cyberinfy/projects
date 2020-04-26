import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuestAdmin } from '../Model/questadmin';
import { AddadminService } from './addadmin.service';

@Component({
  selector: 'app-addadmin',
  templateUrl: './addadmin.component.html',
  styleUrls: ['./addadmin.component.css']
})
export class AddadminComponent implements OnInit {
  adminEmployeeid: number;
  admins: any;
  constructor(private _router: Router, private _addAdminService: AddadminService) { }

  ngOnInit() {
      if (sessionStorage.getItem('valid') === 'true') {
        // tslint:disable-next-line:radix
        this.adminEmployeeid = parseInt(sessionStorage.getItem('employeeid'));
       this.retrieveAll();
      } else {
        this._router.navigateByUrl('/login');
    }
  }

  addadmin() {
      // tslint:disable-next-line:radix
      const employeeid = parseInt((<HTMLInputElement>document.getElementById('employeeid')).value);
      const password = (<HTMLInputElement>document.getElementById('password')).value;
      const admin: QuestAdmin = {
          employeeid: employeeid,
          password: password
      };
      this._addAdminService.performAddAdmin(admin).subscribe((result) => {
        if (result.toString() === 'success') {
            alert('admin added successfully');
                this.retrieveAll();
        } else {
            alert('unable to add admin');
        }
      }
      );
  }

  removeadmin() {
            // tslint:disable-next-line:radix
      const employeeid = (<HTMLInputElement>document.getElementById('employeeidtodelete')).value;
      console.log(employeeid);
      this._addAdminService.performRemoveAdmin(employeeid).subscribe((result) => {
        if (result.toString() === 'success') {
            alert('admin deleted successfully');
            if (employeeid === sessionStorage.getItem('employeeid')) {
                sessionStorage.clear();
                this._router.navigateByUrl('/login');
            }
                this.retrieveAll();
        } else {
            alert('unable to delete admin');
        }
      }
      );
  }

  retrieveAll() {
       this._addAdminService.performRetrieveAll().subscribe((result) => this.admins = result);
  }


}
