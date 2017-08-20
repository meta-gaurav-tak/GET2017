package com.metacube.ShoppingCart.TO;

public class CartEntry {
    private int entryNumber;
    private String productId;
    private int quantity;
    private double costOfOrder;
    public int getEntryNumber() {
        return entryNumber;
    }
    public void setEntryNumber(int entryNumber) {
        this.entryNumber = entryNumber;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getCostOfOrder() {
        return costOfOrder;
    }
    public void setCostOfOrder(double costOfOrder) {
        this.costOfOrder = costOfOrder;
    }
}
