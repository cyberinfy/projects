import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    numbers: any;
  constructor(private router: Router) {
      this.numbers = new Array();
   }

  ngOnInit() {
  }
fetchit() {
    this.removeOptions(document.getElementById('select'));
    const choice = (<HTMLInputElement>document.getElementById('choice')).value;
    const series = (<HTMLInputElement>document.querySelector('input[name="series"]:checked')).value;
    // tslint:disable-next-line:radix
    const preference: number = parseInt((<HTMLInputElement>document.getElementById('preference')).value);
    if ( preference.toString().length === 0) {
        alert('Please give your preference');
        return false;
    } else {

        if (choice === 'First 4 digits') {

            if (preference.toString().length !== 4) {
                alert('Only 4 digit number is accepted');
                return false;
            } else {
                for (let i = 0 ; i < 10 ; i++ ) {
                    this.makeList(series + preference.toString(), this.generate());
                }
            }
        } else if (choice === 'Last 4 digits') {
            if (preference.toString().length !== 4) {
                alert('Only 4 digit numberis accepted');
                return false;
            } else {
                for (let i = 0 ; i < 10 ; i++) {
                    this.makeList(series + this.generate(), preference.toString());
                }
            }
        } else  {
            if (preference.toString().length !== 9) {
                alert('Only 9 digit number is accepted, your first digit will be ' + series);
                return false;
            } else {
                const element = document.createElement('option');
                element.innerText = element.text = series + preference.toString();
                const select = document.getElementById('select');
                select.appendChild(element);
            }
        }
    }
    return true;
}

generate(): string {
    return Math.floor(Math.floor(Math.random() * 90000) + 10000).toString();
}

makeList(first: string, last: string): void {
    const element = document.createElement('option');
    element.innerText = element.text = first + last;
    const select = document.getElementById('select');
    select.appendChild(element);
}

removeOptions(selectbox) {
    for (let i = selectbox.options.length - 1 ; i >= 0 ; i--) {
        selectbox.remove(i);
    }
}

storenumber() {
    localStorage['mobile'] = JSON.stringify((<HTMLInputElement>document.getElementById('select')).value);
    this.navigate();
}

navigate() {
     this.router.navigateByUrl('/register');
}
}
