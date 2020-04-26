import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  useremployeeid: number;
  constructor(private _router: Router) { }

  querystring = '';
  listofquestions = [
    {id: '1', description: 'what is a constructor?', stream: 'Java'},
    {id: '2',  description: 'why java?', stream: 'Java'},
    {id: '3',  description: 'what is an arraylist?', stream: 'Java'},
    {id: '4',  description: 'how does jvm work?', stream: 'Java'},
    {id: '5',  description: 'why java uses compilation?', stream: 'Java'},
    {id: '1', description: 'what is a constructor?', stream: 'Java'},
    {id: '2',  description: 'why java?', stream: 'Java'},
    {id: '3',  description: 'what is an arraylist?', stream: 'Java'},
    {id: '4',  description: 'how does jvm work?', stream: 'Java'},
    {id: '5',  description: 'why java uses compilation?', stream: 'Java'},
    {id: '1', description: 'what is a constructor?', stream: 'Java'},
    {id: '2',  description: 'why java?', stream: 'Java'},
    {id: '3',  description: 'what is an arraylist?', stream: 'Java'},
    {id: '4',  description: 'how does jvm work?', stream: 'Java'},
    {id: '5',  description: 'why java uses compilation?', stream: 'Java'},
    {id: '1', description: 'what is a constructor?', stream: 'Java'},
    {id: '2',  description: 'why java?', stream: 'Java'},
    {id: '3',  description: 'what is an arraylist?', stream: 'Java'},
    {id: '4',  description: 'how does jvm work?', stream: 'Java'},
    {id: '5',  description: 'why java uses compilation?', stream: 'Java'},
    {id: '1', description: 'what is a constructor?', stream: 'Java'},
    {id: '2',  description: 'why java?', stream: 'Java'},
    {id: '3',  description: 'what is an arraylist?', stream: 'Java'},
    {id: '4',  description: 'how does jvm work?', stream: 'Java'},
    {id: '5',  description: 'why java uses compilation?', stream: 'Java'},
    {id: '6',  description: 'who developed java?', stream: 'Java'}];
  ngOnInit() {
      if (sessionStorage.getItem('access') === 'allow') {
        // tslint:disable-next-line:radix
        this.useremployeeid = parseInt(sessionStorage.getItem('employeeid'));
      } else {
        this._router.navigateByUrl('/access');
    }
  }
}
