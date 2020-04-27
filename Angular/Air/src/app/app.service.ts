import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  _url = '../assets/api/data.json';
  constructor(private _http: Http) { }
  getFounders() {
      return this._http.get(this._url)
      .pipe(map((response: Response) => response.json()));
    }
}
