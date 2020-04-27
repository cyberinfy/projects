import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from './category.service';
import { Category } from '../Model/category';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  adminEmployeeid: number;
  categories: any;
  constructor(private _router: Router, private _categoryService: CategoryService) { }

  ngOnInit() {
      if (sessionStorage.getItem('valid') === 'true') {
        // tslint:disable-next-line:radix
        this.adminEmployeeid = parseInt(sessionStorage.getItem('employeeid'));
      } else {
        this._router.navigateByUrl('/login');
    }
    this.retrieveAll();
  }

  addcategory() {
    const categoryname = (<HTMLInputElement>document.getElementById('categoryname')).value;
    const category: Category = {categoryname: categoryname};
    this._categoryService.performAddcategory(category).subscribe((result) => {
        if (result.toString() === 'success') {
            alert('category added successfully');
        } else {
            alert('unable to add category');
        }
    });
    this.retrieveAll();
  }
 removecategory() {
    const categoryname = (<HTMLInputElement>document.getElementById('categoryname')).value;
    this._categoryService.performRemovecategory(categoryname).subscribe((result) => {
        if (result.toString() === 'success') {
            alert('category removed successfully');
        } else {
            alert('unable to remove category');
        }
    });
    this.retrieveAll();
  }

  retrieveAll() {
      this._categoryService.performRetrieveAll().subscribe((result) => this.categories = result);
  }
}


