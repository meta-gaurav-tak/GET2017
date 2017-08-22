package com.metacube.List.DoublyLinkList;

public class DoublyLinkedList<T extends Comparable<T>> {
    private DoublyLinkListNode<T> head=null;
    public int listSize;
    public boolean isEmpty(){
        if(head!=null){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(T data){
        return addAtPosition(data,this.listSize+1);
    }
    public DoublyLinkListNode<T> getHead() {
        return head;
    }
    public void setHead(DoublyLinkListNode<T> head) {
        this.head = head;
    }
    public int getListSize() {
        return listSize;
    }
    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
    public boolean addAtPosition(T data,int position){
        if(position<1 || position>listSize+1){
            throw new IndexOutOfBoundsException();
        } else {
            DoublyLinkListNode<T> newNode=new DoublyLinkListNode<T>();
            newNode.setData(data);
            newNode.setNext(null);
            newNode.setPrevious(null);
            if(head==null){
                this.head=newNode;
                this.listSize++;
                //System.out.println(head.getPrevious());
                return true;
            }
            if(position==1){ 
                newNode.setNext(this.head);
                this.head.setPrevious(newNode);
                this.head=newNode;
                this.listSize++;
                return true;
            } else {
                int pointerCount=1;
                DoublyLinkListNode<T> ptr=this.head;
                while(ptr.getNext()!=null && pointerCount<position-1){
                    ptr=ptr.getNext();
                    pointerCount++;
                }
                newNode.setPrevious(ptr);
                newNode.setNext(ptr.getNext());
                if(ptr.getNext()!=null){
                    ptr.getNext().setPrevious(newNode);
                }
                ptr.setNext(newNode);
            }
            this.listSize++;
            return true;
        }
    }
    
    public DoublyLinkListNode<T> removeByPosition(int index){
        DoublyLinkListNode<T> removedNode = null;
        DoublyLinkListNode<T> ptr=head;
        int counter=1;
        if(index==1){
            ptr.getNext().setPrevious(null);
            head=ptr.getNext();
            return ptr;
        }
        while(ptr.getNext()!=null && counter<index){
            ptr=ptr.getNext();
            counter++;
        }
        if(ptr.getNext()==null && counter==index) {
            removedNode=ptr;
            ptr.getPrevious().setNext(null);
            ptr=null;
        } else if(counter==index){
            removedNode=ptr;
            ptr.getPrevious().setNext(ptr.getNext());
            ptr.getNext().setPrevious(ptr.getPrevious());
            ptr=null;
        }
        return removedNode;
    }
    
    public DoublyLinkListNode<T> removeByValue(T data) {
        DoublyLinkListNode<T> ptr=head;
        DoublyLinkListNode<T> removedNode;
        if (ptr != null && ptr.getData().compareTo(data)==0){
            removedNode=head;
            if(ptr.getNext()!=null){
                ptr.getNext().setPrevious(null);
            }
            this.head = ptr.getNext(); // Changed head
            //System.out.println("at start index");
            return removedNode;
        }
        while(ptr.getNext()!=null && !(ptr.getData().compareTo(data)==0 )){
            ptr=ptr.getNext();
        }
        if(ptr.getNext()!=null && ptr.getData().compareTo(data)==0){
            removedNode=ptr;
            ptr.getNext().setPrevious(ptr.getPrevious());
            ptr.getPrevious().setNext(ptr.getNext());
            ptr=null;
            return removedNode;
        } else if(ptr.getNext()==null && ptr.getData().compareTo(data)==0) {
            removedNode=ptr;
            ptr.getPrevious().setNext(null);
        } else {
           removedNode=null;
        }
        return removedNode;
    }
    
    public void reverseList(){              
        DoublyLinkListNode<T> ptr=this.head;
        DoublyLinkListNode<T> temp=null;
        while(ptr!=null) {
            temp = ptr.getPrevious();
            ptr.setPrevious(ptr.getNext());
            ptr.setNext(temp);
            ptr=ptr.getPrevious();
        }
        if(temp!=null){
            this.head=temp.getPrevious();
        }
    }
    
    public void displayList() {
        DoublyLinkListNode<T> ptr=this.head;
        while(ptr.getNext()!=null) {
            //System.out.println(ptr.getData());
            ptr=ptr.getNext();  
        }
        while(ptr!=null){
            System.out.println(ptr.getData());
            ptr=ptr.getPrevious();
        }
    }
    
    public void sort() {
        if (this.head == null) {
            throw new NullPointerException();
        }
        DoublyLinkListNode<T> firstLoop = this.head;
        DoublyLinkListNode<T> secondLoop;
        while (firstLoop != null) {
            secondLoop = firstLoop.getNext();
            while (secondLoop != null) {
                if (firstLoop.getData().compareTo(secondLoop.getData()) > 0) {
                    swap(firstLoop, secondLoop);
                } 
                secondLoop = secondLoop.getNext();
            }
            firstLoop = firstLoop.getNext();
        }
    }
    
    private void swap(DoublyLinkListNode<T> firstNode, DoublyLinkListNode<T> secondNode) {
        T temp = (T) firstNode.getData();
        firstNode.setData(secondNode.getData());
        secondNode.setData(temp);
    }
    
    /*public static void main(String args[]){
        DoublyLinkedList<Integer> dll=new DoublyLinkedList<Integer>();
        for(int i=0;i<10;i++){
            dll.addAtPosition(new Integer(i), i+1);
        }
       dll.addAtPosition(new Integer(8), 1);
       dll.addAtPosition(new Integer(7), 2);
       dll.addAtPosition(new Integer(6), 3);
       dll.addAtPosition(new Integer(5), 4);
       dll.addAtPosition(new Integer(4), 5);
       dll.addAtPosition(new Integer(3), 6);
       dll.addAtPosition(new Integer(2), 7);
       dll.addAtPosition(new Integer(1), 8);
       dll.sort();
       //dll.removeByValue(new Integer(5));
       //dll.reverseList();
        //sll.addAtPosition(new Integer(1), 1);
        //sll.addAtPosition(new Integer(2), 2);
        //sll.head=sll.mergeSort(sll.head);
       // sll.reverse(sll.head);
        
        
       dll.displayList();
       //sll.removeByPosition(1);
        
       //System.out.println(dll.removeByValue(1));
       //dll.displayList();
    }*/
    
}
