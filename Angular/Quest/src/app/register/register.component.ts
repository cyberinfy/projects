import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
     mobile: string;
  constructor() {
   }

  ngOnInit() {
      this.mobile = localStorage.getItem('mobile').substring(1, 11);
      console.log(this.mobile);
  }
  onViewCreated() {

  }
}
