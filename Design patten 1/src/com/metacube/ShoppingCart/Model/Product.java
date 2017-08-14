package com.metacube.ShoppingCart.Model;

public class Product extends BaseEntity {
	private String productType;
   
	private String productName;
    private double productRate;
    
    public Product() {
    }
    public Product(String productId, String productName, double productRate,String productType) {
        super(productId);
        this.productName = productName;
        this.productRate = productRate;
        this.productType=productType;
    }
    
    //getters and setters
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getProductRate() {
        return productRate;
    }
    public void setProductRate(double productRate) {
        this.productRate = productRate;
    }
    public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
}
