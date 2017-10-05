package com.metacube.Shopping.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.Product.dao.ProductDao;


@Service("productService")
@Transactional
public class DefaultProductService implements ProductService {
    @Resource(name = "hibernateProductDao")
    ProductDao productDao;
    
    public DefaultProductService() {
        
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

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
    public Product editProduct(Product entity,int id) {
        return productDao.edit(entity,id);
    }

    
    public Boolean saveProduct(Product newProduct) {
        return productDao.save(newProduct);
    }
}
