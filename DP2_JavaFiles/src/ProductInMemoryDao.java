package com.metacube.ShoppingCart.Dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.metacube.ShoppingCart.Dao.ProductDao;
import com.metacube.ShoppingCart.Model.BaseEntity;
import com.metacube.ShoppingCart.Model.Product;
import com.metacube.ShoppingCart.Utility.ReadFile;

public class ProductInMemoryDao implements ProductDao {
    
    private Map<String,Product> productMap;
    
    public ProductInMemoryDao() {
        this.productMap = new HashMap<String,Product>();
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    @Override
    public String addProduct(Product product) {
        productMap.put(product.getId(),product);
        return "Product added To List";
    }

    @Override
    public BaseEntity getProduct(String productId) {
        return productMap.get(productId);
    }

    @Override
    public String updateProduct(Product product) {
        productMap.put(product.getId(),product);
        return "Product Updated Successfully";
    }

    @Override
    public String removeProduct(String productId) {
        productMap.remove(productId);
        return "remove successful";
    }

    @Override
    public BaseEntity searchProduct(String productName) {
        for(String key:productMap.keySet()){
            if(productMap.get(key).getProductName() == productName){
                return productMap.get(key);
            }
        }
       return null;
    }
    
    @Override
    /*method that reads the input product file line by line*/
    public void populateProductListFromFile() {
        ReadFile fileReader=new ReadFile();
        List<String> productListString=fileReader.readLineByLine(".\\ProductList.csv");
        for(String product:productListString) {
            System.out.println(product);
            Product newProduct=generateProductObject(product);
            productMap.put(newProduct.getId(),newProduct);
        }
    }
    
    /*generate a product object in response of a line*/
    @Override
    public Product generateProductObject(String line) {
        Product product=new Product();
        StringTokenizer productToken=new StringTokenizer(line,",");
        if(productToken.countTokens()==4) {
            product.setId(productToken.nextToken());
            product.setProductName(productToken.nextToken());
            product.setProductRate(Double.parseDouble(productToken.nextToken()));
            product.setProductType(productToken.nextToken());
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productMap.values();
    }

}
