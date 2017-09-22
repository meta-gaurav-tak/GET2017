import { Component,OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[ProductService]
})
export class AppComponent implements OnInit{
  title = 'Tour of Products';
  products:Product[];
  selectedProduct: Product;
  constructor(private productService: ProductService) {
   }
  
  onSelect(product: Product): void {
    this.selectedProduct = product;
  }
  getProducts(): void {
    this.productService.getProducts().then(
      products => this.products=products);
  }
  ngOnInit():void{
    this.getProducts();
  }
}
