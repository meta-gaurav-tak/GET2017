import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { ProductsComponent } from './products.component';
import { ProductDetailComponent } from './product-detail.component';
import { ContactUsComponent } from './contact-us.component';
import { AddProductComponent } from './add-product.component';
import { DeleteProductComponent } from './delete-product.component';
import { ProductUpdateComponent } from './product-update.component';
const routes:Routes = [
        {
          path:'products',
          component: ProductsComponent
        },
        {
          path: 'dashboard',
          component: DashboardComponent
        },
        {
          path: 'contactus',
          component: ContactUsComponent
        },
        {
          path: '',
          redirectTo: '/dashboard',
          pathMatch: 'full'
        },
        {
          path: 'addproduct',
          component:AddProductComponent
        },
        {
          path:'deleteproduct',
          component:DeleteProductComponent
        },
        {
          path: 'detail/:id',
          component: ProductDetailComponent
        },
        {
          path: 'edit/:id',
          component: ProductUpdateComponent
        }
      ]
@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
  })
export class AppRoutingModule {}