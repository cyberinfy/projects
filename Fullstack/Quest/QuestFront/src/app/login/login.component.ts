import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from './loginservice.service';
import { QuestAdmin } from '../Model/questadmin';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private _router: Router, private _loginServie: LoginserviceService) { }

  ngOnInit() {
  }

  login() {
      let result: any;
      const employeeid = (<HTMLInputElement>document.getElementById('employeeid')).value;
      const password = (<HTMLInputElement>document.getElementById('password')).value;
      if (employeeid.length === 0) {
            alert('please provide a valid Employee ID');
      // tslint:disable-next-line:radix
      } else if ( isNaN(parseInt(employeeid))) {
        alert('please provide a numerical value as Employee ID');
      } else if (password.length === 0) {
          alert('please provide a valid password');
      } else {
        //   tslint:disable-next-line:radix
          const admin: QuestAdmin = {employeeid: parseInt(employeeid), password: password};
          this._loginServie.performLogin(admin).subscribe((res) => {
              result = res; if (result === 'success') {
                  sessionStorage.setItem('employeeid', employeeid);
                  sessionStorage.setItem('valid', 'true');
                  this._router.navigateByUrl('/admin');
                                                      } else {
                                                          alert('invalid username or password');
                                                          sessionStorage.setItem('valid', 'false');
                                                      }});
    }
  }

}
