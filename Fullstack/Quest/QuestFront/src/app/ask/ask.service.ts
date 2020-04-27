import { Injectable } from '@angular/core';
import { HostServer } from '../Model/hostserver';
import { Ask } from '../Model/ask';
import { HttpHeaders, HttpParams, HttpClient, HttpResponse } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { QuestResponse } from '../Model/questresponse';

@Injectable({
  providedIn: 'root'
})
export class AskService {
  private _url = 'http://' + HostServer.url + '/QuestBack/AskController';
  constructor(private _httpClient: HttpClient) { }
  performUpload(data: Ask) {
      const httpHeaders: HttpHeaders = new HttpHeaders({'contenttype': 'application/json'});
      const httpParams = new HttpParams()
      .append('description', data.description)
      .append('screenshot', data.screenshot);
      const options = {
          headers: httpHeaders,
          params: httpParams
      };
      this._httpClient.post(this._url, httpParams, options).
      pipe(map((response: HttpResponse<QuestResponse>) => response.status));
  }
}
