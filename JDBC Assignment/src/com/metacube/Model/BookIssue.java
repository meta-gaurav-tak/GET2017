package com.metacube.Model;

import java.sql.Date;

public class BookIssue {
    private Date issueDate;
    private Date dueDate;
    private int accessionNo;
    private int memberID;
    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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
