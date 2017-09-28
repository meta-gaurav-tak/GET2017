import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { ProductSearchComponent } from './product-search.component'
import { AppComponent }  from './app.component';
import { ProductDetailComponent } from './product-detail.component';
import { ProductsComponent } from './products.component';
import { ProductService } from './product.service';
import { DashboardComponent } from './dashboard.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpModule }    from '@angular/http';
import { ContactUsComponent } from './contact-us.component';
import { FilterPipe } from './pipe';
import { AddProductComponent } from './add-product.component';
import { DeleteProductComponent } from './delete-product.component';
import { ProductUpdateComponent } from './product-update.component';
@NgModule({
  imports:[ 
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule 
  ],
  declarations: [ 
    AppComponent,
    ProductDetailComponent,
    ProductsComponent,
    DashboardComponent,
    ContactUsComponent,
    DeleteProductComponent,
    ProductSearchComponent,
    AddProductComponent,
    ProductUpdateComponent,
    FilterPipe
  ],
  bootstrap:    [ AppComponent ],
  providers:[ ProductService ]
})
export class AppModule {
 }
