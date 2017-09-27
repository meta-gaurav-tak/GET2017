import { Component, Input,OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Product } from './product';
import { Location } from '@angular/common';
import { ProductService } from './product.service';
import 'rxjs/add/operator/switchMap';
@Component({
  selector: 'product-edit',
  templateUrl:'./product-update.component.html',
  styleUrls:['./product-update.component.css'] 
})
export class ProductUpdateComponent implements OnInit {
    @Input() product: Product;
    constructor(
      private productService: ProductService,
      private route: ActivatedRoute,
      private location: Location
    ) {}
    ngOnInit(): void {
      this.route.paramMap
        .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
        .subscribe(product => this.product = product);
    }
    goBack(): void {
      this.location.back();
    }
    save(): void {
      this.productService.update(this.product)
        .then(() => this.goBack());
    }
}