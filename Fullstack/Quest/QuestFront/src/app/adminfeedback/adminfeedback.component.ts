import { Component, OnInit } from '@angular/core';
import { AdminfeedbackService } from './adminfeedback.service';
import { CategoryService } from '../category/category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminfeedback',
  templateUrl: './adminfeedback.component.html',
  styleUrls: ['./adminfeedback.component.css']
})
export class AdminfeedbackComponent implements OnInit {

    queryString: string;
    categories: any;
    feedbackdetails: any;
      adminEmployeeid: number;

  constructor(private _router: Router, private adminfeedbackService: AdminfeedbackService, private _categoryService: CategoryService) { }

  ngOnInit() {
            if (sessionStorage.getItem('valid') === 'true') {
                // tslint:disable-next-line:radix
                this.adminEmployeeid = parseInt(sessionStorage.getItem('employeeid'));
                this.performRetrieveAll();
                this.retrieveAll();
            } else {
                this._router.navigateByUrl('/login');
             }

  }
   retrieveAll() {
      this._categoryService.performRetrieveAll().subscribe((result) => this.categories = result);
  }
  performRetrieveAll() {
      this.adminfeedbackService.performGetFeedback().subscribe((data) => this.feedbackdetails = data);
      console.log('out');
  }
}
