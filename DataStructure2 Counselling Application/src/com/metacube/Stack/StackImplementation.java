package com.metacube.Stack;

public class StackImplementation {
    private StackNode top = null;

    public StackNode getTop() {
        return top;
    }

    public void setTop(StackNode top) {
        this.top = top;
    }
    
    public boolean push(Object data){
        if(data == null){
            throw new IllegalArgumentException();
        }
        StackNode newNode = new StackNode();
        newNode.setData(data);
        newNode.setNext(null);
        if(this.top == null) {
            this.top = newNode;
            return true;
        } else {
            newNode.setNext(this.top);
            this.top = newNode;
            return true;
        }
    }
    public Object pop() {
        if(isEmpty()){
            System.out.println("Stack underflow");
            return null;
        } else {
            StackNode popNode=this.top;
            this.top = this.top.getNext();
            return popNode.getData();
        }
    }
    //to get the top value without removing it
    public Object peep() {
        if(!isEmpty()) {
            return this.top.getData();
        } else {
            return null;
        }
    }
    
    public boolean isEmpty(){
        if(this.top!=null){
            return false;
        } else {
            return true;
        }
    }
}
