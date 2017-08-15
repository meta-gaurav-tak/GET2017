package com.metacube.ShoppingCart.Dao;

import com.metacube.ShoppingCart.Dao.Impl.ProductFileDao;
import com.metacube.ShoppingCart.Dao.Impl.ProductInMemoryDao;

/*class to return singleton object of dao*/ 
public class DaoFactory {
    private static ProductDao productDao;       //singleton Object
    private DaoFactory(){
    }
    public static ProductDao getProductDaoInstance(String name){
        if(productDao==null){
            synchronized(DaoFactory.class){
                if(productDao==null){
                    switch(name){
                        case "In_Memory":
                            productDao = new ProductInMemoryDao();
                            break;
                        case "File":
                            productDao = new ProductFileDao();
                            break;
                    }
                }
            }
        }
        return productDao;
    }
}
