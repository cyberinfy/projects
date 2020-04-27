import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { QuestResponse } from '../Model/questresponse';
@Injectable({
  providedIn: 'root'
})
export class AccessService {
private _url = 'http://172.24.128.92:8080/QuestBack/AccessController';
  constructor(private _http: HttpClient) { }
performAccess(employeeid: string) {
    const headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    const httpParams: HttpParams = new HttpParams()
    .append('employeeid', employeeid);
    const options = {
        headers: headers,
        params: httpParams
    };
    return this._http.post(this._url, httpParams, options).
    pipe(map((response: HttpResponse<QuestResponse>) => response.status));
}
}
