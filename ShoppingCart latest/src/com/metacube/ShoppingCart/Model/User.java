package com.metacube.ShoppingCart.Model;

public class User {
    private String userName;
    private String password;
    private String userEmail;
    private String nameOfUser;
    private String contactNumber;
    private String ShippingAddress;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getNameOfUser() {
        return nameOfUser;
    }
    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getShippingAddress() {
        return ShippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }
    
}
