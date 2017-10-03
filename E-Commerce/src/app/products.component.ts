import { Component,OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import{ AppComponent } from './app.component';
import { Router } from '@angular/router'
@Component({
  selector: 'my-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{
  products:Product[];
  selectedProduct: Product;
  constructor(private productService: ProductService,private router:Router) {  
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
  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedProduct.id]);
  }

  editProduct():void {
    this.router.navigate(['/edit',this.selectedProduct.id])
  }

  add(name: string,price:number,imageUrl:string): void {
    name = name.trim();
    if (!name) { return; }
    this.productService.create(name,price,imageUrl)
      .then(product => {
        this.products.push(product);
        this.selectedProduct = null;
      });
  }

  delete(product: Product): void {
    this.productService
        .delete(product.id)
        .then(() => {
          this.products = this.products.filter(h => h !== product);
          if (this.selectedProduct === product) { this.selectedProduct = null; }
        });
  }
}
