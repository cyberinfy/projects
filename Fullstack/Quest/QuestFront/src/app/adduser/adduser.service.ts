import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { QuestResponse } from '../Model/questresponse';
import { User } from '../Model/user';
@Injectable({
  providedIn: 'root'
})
export class AdduserService {
private _url = 'http://192.168.0.4:8080/QuestBack/AddUserController';
  constructor(private _http: HttpClient) { }
performAdduser(user: User) {
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'add')
    .append('employeeid', user.employeeid.toString())
    .append('name', user.name)
    .append('lg', user.lg);

    const options = {
        headers: headers,
        params: httpParams
    };
    return this._http.post(this._url, httpParams, options).
    pipe(map((response: HttpResponse<QuestResponse>) => response.status));
}
performRemoveuser(user: string) {
    console.log(user);
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'remove')
    .append('employeeid', user);
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
    pipe(map((response: HttpResponse<User[]>) => response));
}
}
