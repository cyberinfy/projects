import { Pipe, PipeTransform } from '@angular/core';
import { Feed } from '../Model/feed';

@Pipe({
  name: 'filterstream'
})
export class FilterPipe implements PipeTransform {

  transform(items: Feed[], value: string, label: string): any[] {
    if (!items) { return []; }
    if (!value) { return  items; }
    if (value === '' || value === null) { return []; }
    console.log(value.toLowerCase() + ',' + items[0].feedback + ',' + label.toLowerCase());
    return items.filter(e => e[label].toLowerCase().indexOf(value.toLowerCase()) > -1 );
  }



}
