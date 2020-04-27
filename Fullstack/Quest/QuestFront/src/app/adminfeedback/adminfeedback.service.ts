import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse, HttpParams } from '@angular/common/http';
import { HostServer } from '../Model/hostserver';
import { Feed } from '../Model/feed';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class AdminfeedbackService {
private _url = 'http://' + HostServer.url + '/QuestBack/FeedbackController';
  constructor(private _httpClient: HttpClient) { }

performGetFeedback() {
    const headers: HttpHeaders = new HttpHeaders({ 'content-type': 'application/json' } );
    const httpParams: HttpParams = new HttpParams()
    .append('operation', 'retrieval');
    const options = {headers: headers,
    params: httpParams};
    console.log('in');
     return this._httpClient.post(this._url, httpParams, options).
     pipe(map((response: HttpResponse<Feed[]>) => response));
}
}
