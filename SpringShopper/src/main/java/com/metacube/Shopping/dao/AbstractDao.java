package com.metacube.Shopping.dao;
import java.io.Serializable;

import com.metacube.Shopping.Product.Model.Product;

public interface AbstractDao<T, ID extends Serializable>
{
    Boolean save(T entity);
    T findOne(ID primaryKey);
    Iterable<T> findAll();
    boolean delete(int id);
    boolean exists(ID primaryKey);
    Product edit(Product product, int primaryKey);
}
