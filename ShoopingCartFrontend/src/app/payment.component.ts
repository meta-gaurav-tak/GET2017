
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from './order.service';
import { Order } from './order';

@Component({
selector: 'my-payment',
templateUrl: './payment.component.html',
})
export class PaymentComponent implements OnInit{
    
    constructor(private orderService:OrderService){}

    ngOnInit(): void {
        
      }
    saveOrder(cardN:number,cardE:number,cardC:number):void{
       let order:Order;
         console.log(cardN);
            order.cardNumber=cardN;
            order.cvv=cardC;
            order.amount=10000;
            console.log(order.amount);
          this.orderService.saveOrder(order);
      }


}