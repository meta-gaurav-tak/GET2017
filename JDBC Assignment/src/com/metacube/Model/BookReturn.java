package com.metacube.Model;

import java.sql.Date;

public class BookReturn {
    private Date issueDate;
    private Date returnDate;
    private int accessionNo;
    private int memberID;
    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public int getAccessionNo() {
        return accessionNo;
    }
    public void setAccessionNo(int accessionNo) {
        this.accessionNo = accessionNo;
    }
    public int getMemberID() {
        return memberID;
    }
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
    
}
