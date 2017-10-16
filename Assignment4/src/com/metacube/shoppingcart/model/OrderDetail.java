package com.metacube.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetail")
public class OrderDetail {

	@Id
	@Column(name = "orderDetailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	@Column(name = "quantity")
	private int quantity;

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
