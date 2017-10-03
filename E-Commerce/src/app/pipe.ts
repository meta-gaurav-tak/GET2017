import { Injectable, Pipe, PipeTransform } from '@angular/core';
import { Product } from './Product'

@Pipe({
name: 'filterByName',
})


export class FilterPipe implements PipeTransform {
transform(pr: Product[], args: string): any {
if (args == null) return pr;

return pr.filter(function (filterByName) {
return filterByName.name.toLowerCase().indexOf(args.toLowerCase()) !== -1;
})
}
}