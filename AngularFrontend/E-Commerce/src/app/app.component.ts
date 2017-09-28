import { Component } from '@angular/core';
@Component({
    selector:'my-app',
    template:`
    <h1>{{title}}</h1>
    <nav class='navbar navbar-inverse'>
        <ul class="nav navbar-nav" >
            <li><a routerLink="/dashboard" routerLinkActive="active">Dashboard</a></li>
            <li><a routerLink="/products" routerLinkActive="active">Products</a></li>
            <li><a routerLink="/contactus" routerLinkActive="active">ContactUs</a></li>
        </ul>
    </nav>
    <router-outlet></router-outlet>
    `
})
export class AppComponent {
    title = 'Tour of Products';
}