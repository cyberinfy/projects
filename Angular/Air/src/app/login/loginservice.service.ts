import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { QuestAdmin } from '../Model/questadmin';
import { map } from 'rxjs/operators';
import { QuestResponse } from '../Model/questresponse';
@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {
private _url = 'http://172.24.128.92:8080/QuestBack/LoginController';
  constructor(private _http: HttpClient) { }
performLogin(admin: QuestAdmin) {
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('employeeid', admin.employeeid.toString())
    .append('password', admin.password);
    const options = {
        headers: headers,
        params: httpParams
    };
    return this._http.post(this._url, httpParams, options).
    pipe(map((response: HttpResponse<QuestResponse>) => response.status));
}
}
