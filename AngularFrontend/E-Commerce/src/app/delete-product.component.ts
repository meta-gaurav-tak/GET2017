import { Component,Input } from '@angular/core';
import { Product } from './product';
import { ProductsComponent } from './products.component';
@Component({
    selector:'delete-product',
    templateUrl:'./delete-product.component.html'
})
export class DeleteProductComponent {
    @Input() productToDelete:Product;
    constructor(private products: ProductsComponent) {    
    }
    delete():void {
        this.products.delete(this.productToDelete);
    }
}