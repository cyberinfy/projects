import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  founders: any;
  constructor(private appService: AppService) {
  }

  ngOnInit() {
    this.appService.getFounders().subscribe((data) => this.founders = data);
  }

}
