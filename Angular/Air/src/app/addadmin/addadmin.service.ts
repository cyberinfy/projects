import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { QuestAdmin } from '../Model/questadmin';
import { map } from 'rxjs/operators';
import { QuestResponse } from '../Model/questresponse';
import { RetrieveAdmin } from '../Model/RetrieveAdmin';
@Injectable({
  providedIn: 'root'
})
export class AddadminService {
private _url = 'http://172.24.128.92:8080/QuestBack/AddAdminController';
  constructor(private _http: HttpClient) { }
performAddAdmin(admin: QuestAdmin) {
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'add')
    .append('employeeid', admin.employeeid.toString())
    .append('password', admin.password);
    const options = {
        headers: headers,
        params: httpParams
    };
    return this._http.post(this._url, httpParams, options).
    pipe(map((response: HttpResponse<QuestResponse>) => response.status));
}
performRemoveAdmin(admin: string) {
    console.log(admin);
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'remove')
    .append('employeeid', admin);
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
    pipe(map((response: HttpResponse<RetrieveAdmin[]>) => response));
}
}
