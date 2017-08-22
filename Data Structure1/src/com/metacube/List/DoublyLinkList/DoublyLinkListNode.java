package com.metacube.List.DoublyLinkList;

public class DoublyLinkListNode<T extends Comparable<T>> {
	private DoublyLinkListNode<T> previous=null;
	private T data;
    private DoublyLinkListNode<T> next=null;
	public DoublyLinkListNode<T> getPrevious() {
		return previous;
	}
	public void setPrevious(DoublyLinkListNode<T> previous) {
		this.previous = previous;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public DoublyLinkListNode<T> getNext() {
		return next;
	}
	public void setNext(DoublyLinkListNode<T> next) {
		this.next = next;
	}
     
}
