package com.metacube.Stack;


public class StackNode {
    private Object data;
    private StackNode next=null;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public StackNode getNext() {
        return next;
    }
    public void setNext(StackNode next) {
        this.next = next;
    }
    
}
