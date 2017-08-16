package com.metacube.ShoppingCart.Dao;

import java.util.List;

import com.metacube.ShoppingCart.Model.BaseEntity;
import com.metacube.ShoppingCart.Model.Product;

public interface ProductDao {
    public abstract String addProduct(Product product);
    public abstract BaseEntity getProduct(String productId);
    public abstract String updateProduct(Product product);
    public abstract String removeProduct(String productId);
    public abstract BaseEntity searchProduct(String productName);
    public abstract Product generateProductObject(String line);
    public abstract List<Product> getAllProducts();
    public void populateProductListFromFile();
}
