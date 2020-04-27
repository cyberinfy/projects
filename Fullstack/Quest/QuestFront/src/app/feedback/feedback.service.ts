import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse, HttpParams } from '@angular/common/http';
import { HostServer } from '../Model/hostserver';
import { Feed } from '../Model/feed';
import { map } from 'rxjs/operators';
import { QuestResponse } from '../Model/questresponse';
@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
private _url = 'http://' + HostServer.url + '/QuestBack/FeedbackController';
  constructor(private _httpClient: HttpClient) { }

performInsertion(data: Feed) {
    const headers: HttpHeaders = new HttpHeaders({ 'content-type': 'application/json' } );
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'insertion')
    .append('employeeid', data.employeeid.toString())
    .append('stream', data.stream)
    .append('feedback', data.feedback);
    const options = {headers: headers,
    params: httpParams};
    console.log('in');
     return this._httpClient.post(this._url, httpParams, options).
     pipe(map((response: HttpResponse<QuestResponse>) => response.status));
}
}
