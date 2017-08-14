package com.metacube.ShoppingCart.Facade;

import java.util.List;

import com.metacube.ShoppingCart.Dao.DaoFactory;
import com.metacube.ShoppingCart.Dao.ProductDao;
import com.metacube.ShoppingCart.Model.Product;

public class ProductFacade {
    ProductDao productDaoInstance=DaoFactory.getProductDaoInstance("In_Memory");
    public String addProduct(Product product){
    	if((productDaoInstance.getProduct(product.getId())!=null)){
    		return "Product Already Exists With this ID";
    	} else{
    		return productDaoInstance.addProduct(product);
    	}
    }
    public String removeProduct(Product product){
    	if((productDaoInstance.getProduct(product.getId())!=null)){
    		return productDaoInstance.removeProduct(product.getId());
    	} else {
    		return "Product Does not exist";
    	}
    }
    public Product searchproductbyName(Product product) throws NullPointerException{
    	Product searchResult=(Product)productDaoInstance.searchProduct(product.getProductName());
    	if(searchResult!=null) {
    		return searchResult;
    	}
    	else {
    		throw new NullPointerException();
    	}
    }
    public List<Product> getAllProducts() throws NullPointerException{
        if(productDaoInstance.getAllProducts()!=null){
        	return productDaoInstance.getAllProducts();
        } else {
        	throw new NullPointerException();
        }
    }
}
