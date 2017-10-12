package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;

public interface OrderFacade {

	boolean saveOrder(String id, Order order);

	Iterable<Order> getAllOrder(String id);

	Iterable<OrderDetail> getOrderDetail(int id);

}
