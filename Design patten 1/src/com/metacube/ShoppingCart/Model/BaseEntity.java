package com.metacube.ShoppingCart.Model;

public class BaseEntity {
    String id;

    public BaseEntity(String id) {
        this.id = id;
    }

    public BaseEntity() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
