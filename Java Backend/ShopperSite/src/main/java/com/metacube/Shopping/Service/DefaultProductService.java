package com.metacube.Shopping.Service;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.Product.dao.ProductDao;



public class DefaultProductService implements ProductService {
    ProductDao productDao;

    public DefaultProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Iterable<Product> getAllProducts()
    {
        return productDao.findAll();
    }

    public Product getProductById(final int id)
    {
        return productDao.findOne(id);
    }

    public Boolean deleteProduct(int id) {
        
        return productDao.delete(id);
    }
    public Boolean editProduct(Product entity,int id) {
        return productDao.edit(entity,id);
    }

    
    public Boolean saveProduct(Product newProduct) {
        return productDao.save(newProduct);
    }
}
