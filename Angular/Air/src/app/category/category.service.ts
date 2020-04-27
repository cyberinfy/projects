import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Category } from '../Model/Category';
import { map } from 'rxjs/operators';
import { QuestResponse } from '../Model/questresponse';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CategoryService implements OnInit {
private _url = 'http://192.168.0.4:8080/QuestBack/CategoryController';
  adminEmployeeid: number;
  constructor(private _router: Router, private _http: HttpClient) { }

  ngOnInit() {
      if (sessionStorage.getItem('valid') === 'true') {
        // tslint:disable-next-line:radix
        this.adminEmployeeid = parseInt(sessionStorage.getItem('employeeid'));
      } else {
        this._router.navigateByUrl('/login');
    }
  }

performAddcategory(category: Category) {
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'add')
    .append('categoryname', category.categoryname);
    const options = {
        headers: headers,
        params: httpParams
    };
    return this._http.post(this._url, httpParams, options).
    pipe(map((response: HttpResponse<QuestResponse>) => response.status));
}
performRemovecategory(category: string) {
    console.log(category);
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'remove')
    .append('categoryname', category);
    const options = {
        headers: headers,
        params: httpParams
    };
    return this._http.post(this._url, httpParams, options).
    pipe(map((response: HttpResponse<QuestResponse>) => response.status));
}
performRetrieveAll() {
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'retrieve');
    const options = {
        headers: headers,
        params: httpParams
    };
    return this._http.post(this._url, httpParams, options).
    pipe(map((response: HttpResponse<Category[]>) => response));
}
}
