package com.metacube.List.SinglyLinkList;

public class SinglyLinkListNode <T extends Comparable<T>> {
    private T data;
    private SinglyLinkListNode<T> next=null;
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public SinglyLinkListNode<T> getNext() {
        return next;
    }
    public void setNext(SinglyLinkListNode<T> next) {
        this.next = next;
    }
    
}
