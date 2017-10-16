package com.metacube.shoppingcart.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Column(name = "cardNumber")
	private String cardNumber;

	@Column(name = "cvv")
	private int cvv;
	
	
	@Column(name = "orderAmount")
	private double orderAmount;

	@Column(name = "userName")
	private String userName;


	/**
	 *
	 */
	@Column(name = "dateOfOrder")
	private Date dateOfOrder;

	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

	

}
