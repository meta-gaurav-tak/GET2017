package com.metacube.ShoppingCart.Dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import com.metacube.ShoppingCart.Model.BaseEntity;
import com.metacube.ShoppingCart.Model.Product;
import com.metacube.ShoppingCart.Utility.ReadFile;
import com.metacube.ShoppingCart.Dao.ProductDao;

public class ProductFileDao implements ProductDao {
    
    private HashMap<String,Product> productMap;        // a map to load the product list to main memory from file
    
    public HashMap<String, Product> getProductMap() {
        return productMap;
    }
    public void setProductMap(HashMap<String, Product> productMap) {
        this.productMap = productMap;
    }
    
    /*method that reads the input product file line by line*/
    public void populateProductListFromFile() {
        ReadFile fileReader=new ReadFile();
        List<String> productListString=fileReader.readLineByLine(".\\src\\ProductList.csv");
        for(String product:productListString) {
            Product newProduct=generateProductObject(product);
            productMap.put(newProduct.getId(),newProduct);
        }
    }
    
    /*generate a product object in response of a line*/
    @Override
    public Product generateProductObject(String line) {
        Product product=new Product();
        StringTokenizer productToken=new StringTokenizer(line,",");
        if(productToken.countTokens()==3) {
            product.setId(productToken.nextToken());
            product.setProductName(productToken.nextToken());
            product.setProductRate(Double.parseDouble(productToken.nextToken()));
        }
        return product;
    }
    
    @Override
    public String addProduct(Product product) {
        //logic to add product to file goes here
        return null;
    }
    @Override
    public BaseEntity getProduct(String productId) {
        // logic to get product from productMap
        return null;
    }
    @Override
    public String updateProduct(Product product) {
        //logic to update an existing product
        return null;
    }
    @Override
    public String removeProduct(String productId) {
        // logic to remove a product from productList
        return null;
    }
    @Override
    public BaseEntity searchProduct(String productName) {
        // logic to create a product search
        return null;
    }
    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productMap.values();
    }
}
