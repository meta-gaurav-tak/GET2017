
package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import com.metacube.shoppingcart.model.CartItem;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;
import com.metacube.shoppingcart.model.Product;

public interface BaseDao<T, ID extends Serializable> {

	T findOne(ID primaryKey);
	
	T getOne(String id);

	Iterable<T> findAll();

	boolean delete(ID primaryKey);

	boolean exists(ID primaryKey);

	Product update(int id, String name, double price);

	Product save(int id, String name, double price);

	Iterable<CartItem> getAll(final String id);

	CartItem addToCart(String pname, double price, int productId, String userId);
	
	boolean deleteFromCart(String username);
	
	int saveOrder(String id, Order order);
	
	void saveCart(List<CartItem> cart, int orderId);
	
	Iterable<Order> getAllOrder(String id);
	
	Iterable<OrderDetail> getOrderDetail(int id);
}
