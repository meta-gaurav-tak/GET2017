import { Component } from '@angular/core';
import { Product } from './product';
import { ProductsComponent } from './products.component';
@Component({
    selector:'add-product',
    templateUrl:'./add-product.component.html',
    styleUrls:['./add-product.component.css']
})

export class AddProductComponent {
    constructor(private products: ProductsComponent) {
        
       }
       
    add(name: string,price:number,imageUrl:string): void {
        this.products.add(name,price,imageUrl);
      }
    
}