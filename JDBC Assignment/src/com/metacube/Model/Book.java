package com.metacube.Model;

import java.sql.Date;

public class Book {
    private int accession_no;
    private char status;
    private Date purchaseDate;
    private double price;
    private int titleId;
    public int getAccession_no() {
        return accession_no;
    }
    public void setAccession_no(int accession_no) {
        this.accession_no = accession_no;
    }
    public char getStatus() {
        return status;
    }
    public void setStatus(char status) {
        this.status = status;
    }
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getTitleId() {
        return titleId;
    }
    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }
}
