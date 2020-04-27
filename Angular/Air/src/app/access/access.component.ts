import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccessService } from './access.service';

@Component({
  selector: 'app-access',
  templateUrl: './access.component.html',
  styleUrls: ['./access.component.css']
})
export class AccessComponent implements OnInit {

  constructor(private _router: Router, private _accessService: AccessService) { }

  ngOnInit() {
  }

  access() {
    // tslint:disable-next-line:radix
    const employeeId = (<HTMLInputElement>document.getElementById('employeeid')).value;
    this._accessService.performAccess(employeeId).subscribe((result) => {
        if (result.toString() === 'success') {
            console.log(result);
            sessionStorage.setItem('employeeid', employeeId);
            sessionStorage.setItem('access', 'allow');
              this._router.navigateByUrl('/user');
        } else {
            alert('please contact your respective faculty');
        }
    });
  }
}
