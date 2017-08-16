package com.metacube.ShoppingCart.Facade;

public class FacadeFactory {
	private static CartFacade cartFacade;       //singleton Object
	private static ProductFacade productFacade;		//singleton object
    private FacadeFactory(){
    }
    public static CartFacade getCartFacadeDaoInstance(){
        if(cartFacade==null){
            synchronized(FacadeFactory.class){
                if(cartFacade==null){
                    cartFacade=new CartFacade();
                }
            }
        }
        return cartFacade;
    }
    public static ProductFacade getProductFacadeDaoInstance(){
        if(productFacade==null){
            synchronized(FacadeFactory.class){
                if(productFacade==null){
                    productFacade=new ProductFacade();
                }
            }
        }
        return productFacade;
    }
}
