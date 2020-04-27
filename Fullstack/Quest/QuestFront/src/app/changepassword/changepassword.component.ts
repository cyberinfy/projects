import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuestAdmin } from '../Model/questadmin';
import { ChangepasswordService } from './changepassword.service';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {

  constructor(private _router: Router, private _changePasswordService: ChangepasswordService) { }
 ngOnInit() {

  }

  changePassword() {
      let result: any;
    const employeeid = (<HTMLInputElement>document.getElementById('employeeid')).value;
    const oldpassword = (<HTMLInputElement>document.getElementById('oldpassword')).value;
    const newpassword = (<HTMLInputElement>document.getElementById('newpassword')).value;
    const confirmpassword = (<HTMLInputElement>document.getElementById('confirmpassword')).value;
     if (employeeid.length === 0) {
            alert('please provide a valid Employee ID');
      // tslint:disable-next-line:radix
      } else if ( isNaN(parseInt(employeeid))) {
        alert('please provide a numerical value as Employee ID');
      } else if (oldpassword.length === 0) {
          alert('please provide a valid old password');
      } else if (newpassword.length === 0) {
          alert('please provide a valid new password');
      } else if (newpassword !== confirmpassword) {
          alert('new password doesn\'t match confirm password');
      } else {
          // tslint:disable-next-line:radix
          const admin: QuestAdmin = {employeeid: parseInt(employeeid), password: newpassword};
          this._changePasswordService.performChangePassword(admin).subscribe((res) => {
              result = res; if (result === 'success') {
                  this._router.navigateByUrl('/login');
                                                      } else {
                                                          alert('invalid username or password mismatch');
                                                      }});
      }
  }
}
