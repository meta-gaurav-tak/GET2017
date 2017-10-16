package com.metacube.shoppingcart.dao.cart;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.model.CartItem;

@Repository("hibernateCartDao")
public class HibernateCartDao extends HibernateDao<CartItem, String>
		implements
			CartDao {
	public HibernateCartDao() {
		super(CartItem.class);
	}
}
