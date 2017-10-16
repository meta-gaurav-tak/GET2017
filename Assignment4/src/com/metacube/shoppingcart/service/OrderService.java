package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;

public interface OrderService {

	boolean saveCart(String id, Order order);

	Iterable<Order> getAllOrder(String id);

	Iterable<OrderDetail> getOrderDetail(int id);

}
