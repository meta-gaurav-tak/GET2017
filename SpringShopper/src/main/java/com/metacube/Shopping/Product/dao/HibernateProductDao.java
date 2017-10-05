/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.Shopping.Product.dao;

import org.springframework.stereotype.Repository;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.dao.HibernateDao;



/**
 * The Class HibernateProductDao.
 */
@Repository("hibernateProductDao")
public class HibernateProductDao extends HibernateDao<Product, Integer>
        implements
            ProductDao {

    /**
     * Instantiates a new hibernate product dao.
     */
    public HibernateProductDao() {
        super(Product.class);
    }

}
