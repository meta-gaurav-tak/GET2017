import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise'
import { Product } from './product';

@Injectable()
export class ProductService {
    private productsUrl = 'http://localhost:8080/SpringShopper/product';  //web api url
    private headers = new Headers({'Content-Type': 'application/json'});
    constructor(private http: Http){}
    
    update(product: Product): Promise<Product> {
      const url = `${this.productsUrl}/${product.id}`;
      return this.http
        .put(url, JSON.stringify(product), {headers: this.headers})
        .toPromise()
        .then(() => product)
        .catch(this.handleError);
    }
    getProducts(): Promise<Product[]> {
        return this.http.get(this.productsUrl)
                .toPromise()
                .then((data) => data.json())
                .catch(this.handleError);
    }

    private handleError(error:any): Promise<any> {
        console.error('An error occured',error);
        return Promise.reject(error.message || error);
    }
    getProductsSlowly(): Promise<Product[]> {
        return new Promise(resolve => {
          setTimeout(() => resolve(this.getProducts()), 2000);
        });
    }
    getProduct(id:number):Promise<Product>{
        const url = `${this.productsUrl}/${id}`;
        return this.http.get(url)
                .toPromise()
                .then(response => response.json() as Product )
                .catch(this.handleError);
    }

    create(name: string,price:number,imageUrl:string): Promise<Product> {
        return this.http
          .post(this.productsUrl, JSON.stringify({name: name,price: +price,imageUrl: imageUrl}), {headers: this.headers})
          .toPromise()
          .then(res => res.json().data as Product)
          .catch(this.handleError);
      }
    
    delete(id: number): Promise<void> {
        const url = `${this.productsUrl}/${id}`;
        return this.http.delete(url, {headers: this.headers})
          .toPromise()
          .then(() => null)
          .catch(this.handleError);
      }
}