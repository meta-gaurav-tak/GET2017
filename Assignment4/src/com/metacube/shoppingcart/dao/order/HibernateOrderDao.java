package com.metacube.shoppingcart.dao.order;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.model.Order;

@Repository("hibernateOrderDao")
public class HibernateOrderDao extends HibernateDao<Order, Integer>
implements
OrderDao {
	public HibernateOrderDao() {
		super(Order.class);
	}
}
