package com.metacube.Model;

public class Title {
    
    private int titleId;
    private String titleName;
    private int publisherId;
    private int subjectId;
    public int getTitleId() {
        return titleId;
    }
    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }
    public String getTitleName() {
        return titleName;
    }
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
    public int getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
    public int getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
}
