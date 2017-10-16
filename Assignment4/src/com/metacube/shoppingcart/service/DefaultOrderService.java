package com.metacube.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.order.OrderDao;
import com.metacube.shoppingcart.model.CartItem;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;

@Service("orderService")
@Transactional
public class DefaultOrderService implements OrderService {
	@Resource(name = "hibernateOrderDao")
	OrderDao orderDao;
	@Resource(name = "cartService")
	CartService cartService;
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public boolean saveCart(String id, Order order) {

		int orderId = orderDao.saveOrder(id, order);
		Iterable<CartItem> cart = cartService.getAll(id);
		System.out.println("in cart" + cart.toString());
		List<CartItem> cartModel = new ArrayList<CartItem>();
		for (CartItem cartObj : cart) {
			cartModel.add(cartObj);
		}
		orderDao.saveCart(cartModel, orderId);
		cartService.checkout(id);
		return true;
	}

	@Override
	public Iterable<Order> getAllOrder(String id) {
		return orderDao.getAllOrder(id);
	}

	@Override
	public Iterable<OrderDetail> getOrderDetail(int id) {
		return orderDao.getOrderDetail(id);
	}
}
