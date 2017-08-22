package com.metacube.List.SinglyLinkList;

public class SinglyLinkedList<T extends Comparable<T>> {
    private SinglyLinkListNode<T> head=null;
    public int listSize;
    public SinglyLinkListNode<T> getHead() {
        return head;
    }
    public void setHead(SinglyLinkListNode<T> head) {
        this.head = head;
    }
    public int getListSize() {
        return listSize;
    }
    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
    
    public boolean isEmpty(){
        if(head!=null){
            return true;
        }else{
            return false;
        }
    }
    public boolean add(T data){
        return addAtPosition(data,listSize+1);
    }
    public boolean addAtPosition(T data,int position){
        if(position<1 || position>listSize+1){
            throw new IndexOutOfBoundsException();
        } else {
            SinglyLinkListNode<T> newNode=new SinglyLinkListNode<T>();
            newNode.setData(data);
            newNode.setNext(null);
            if(position==1){ 
                newNode.setNext(this.head);
                this.head=newNode;  
            } else {
            int pointerCount=1;
            SinglyLinkListNode<T> ptr=this.head;
            while(ptr.getNext()!=null && pointerCount<position-1){
                ptr=ptr.getNext();
                pointerCount++;
            }
            newNode.setNext(ptr.getNext());
            ptr.setNext(newNode);
            }
            this.listSize++;
            return true;
        }
   }
    
   public SinglyLinkListNode<T> removeByValue(T data){
       SinglyLinkListNode<T> ptr=head;
       SinglyLinkListNode<T> removedNode;
       if (ptr != null && ptr.getData().compareTo(data)==0)
       {
           removedNode=head;
           this.head = ptr.getNext(); // Changed head
           
           System.out.println("at start index");
           return removedNode;
       }
       while(ptr.getNext()!=null && !(ptr.getNext().getData().compareTo(data)==0 )){
           ptr=ptr.getNext();
       }
       if(ptr.getNext()!=null && ptr.getNext().getData().compareTo(data)==0){
           removedNode=ptr.getNext();
           ptr.setNext((ptr.getNext()).getNext());
           return removedNode;
       } else if(ptr.getNext()==null && ptr.getData().compareTo(data)==0) {
           removedNode=ptr;
           ptr=null;
       } else {
          removedNode=null;
       }
       return removedNode;
   }
   
   public SinglyLinkListNode<T> removeByPosition(int index) {
       SinglyLinkListNode<T> removedNode = null;
       SinglyLinkListNode<T> ptr=head;
       int counter=1;
       if(index==1){
           head=ptr.getNext();
           return ptr;
       }
       while(ptr.getNext()!=null && counter<index-1){
           ptr=ptr.getNext();
           counter++;
       }
       if(ptr.getNext()==null && counter==index) {
           removedNode=ptr;
           ptr=null;
       } else if(counter==index-1){
           removedNode=ptr.getNext();
           ptr.setNext(ptr.getNext().getNext());
       }
       return removedNode;
   }
   
   void reverse(SinglyLinkListNode<T> node) {
       SinglyLinkListNode<T> prev = null;
       SinglyLinkListNode<T> current = node;
       SinglyLinkListNode<T> next = null;
       while (current != null) {
           next = current.getNext();
           current.setNext(prev);
           prev = current;
           current = next;
       }
       node = prev;
       this.head=node;
   
   }
   private SinglyLinkListNode<T> sortedMerge(SinglyLinkListNode<T> a, SinglyLinkListNode<T> b) {
       SinglyLinkListNode<T> result = null;
       if (a == null)
           return b;
       if (b == null)
           return a;
       if( a.getData().compareTo(b.getData())<0) {
           result = a;
           result.setNext (sortedMerge(a.getNext(), b));
       } else {
           result = b;
           result.setNext(sortedMerge(a, b.getNext()));
       }
       return result;
   }

   public SinglyLinkListNode<T> mergeSort(SinglyLinkListNode<T> h) {
       if (h == null || h.getNext() == null) {
           return h;
       }
       SinglyLinkListNode<T> middle = getMiddle(h);
       SinglyLinkListNode<T> nextofmiddle = middle.getNext();
       middle.setNext(null);
       // Apply mergeSort on left list
       SinglyLinkListNode<T> left = mergeSort(h);
       // Apply mergeSort on right list
       SinglyLinkListNode<T> right = mergeSort(nextofmiddle);
       // Merge the left and right lists
       SinglyLinkListNode<T> sortedlist = sortedMerge(left, right);
       return sortedlist;
   }

   // Utility function to get the middle of the linked list
   private SinglyLinkListNode<T> getMiddle(SinglyLinkListNode<T> h) {
       if (h == null)
           return h;
       SinglyLinkListNode<T> fastptr = h.getNext();
       SinglyLinkListNode<T> slowptr = h;  
       // Move fastptr by two and slow ptr by one
       // Finally slowptr will point to middle node
       while (fastptr != null) {
           fastptr = fastptr.getNext();
           if(fastptr!=null) {
               slowptr = slowptr.getNext();
               fastptr=fastptr.getNext();
           }
       }
       return slowptr;
   }
   
   public void displayList() {
       SinglyLinkListNode<T> ptr=this.head;
       while(ptr!=null) {
           System.out.println(ptr.getData());
           ptr=ptr.getNext();
       }
   }
  /* public static void main(String args[]){
       SinglyLinkedList<Integer> sll=new SinglyLinkedList<Integer>();
       for(int i=0;i<10;i++){
           sll.addAtPosition(new Integer(i), i+1);
       }
       //sll.addAtPosition(new Integer(1), 1);
       //sll.addAtPosition(new Integer(2), 2);
       //sll.head=sll.mergeSort(sll.head);
       //sll.reverse(sll.head);
       
       sll.add(188);
       sll.displayList();
       //sll.removeByPosition(1);
       
       System.out.println(sll.removeByValue(1));
       sll.displayList();
   }*/
}