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
    //adds to the end of list
    public boolean add(T data){
        return addAtPosition(data,listSize+1);
    }
    //adds at a position if it exists and is valid
    public boolean addAtPosition(T data,int position){
        if(position<1 || position>listSize+1){
            throw new IllegalArgumentException();
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
   
   //remove the first occurrence of a element by its value
   public SinglyLinkListNode<T> removeByValue(T data){
       SinglyLinkListNode<T> ptr=head;
       SinglyLinkListNode<T> removedNode;
       if (ptr != null && ptr.getData().compareTo(data)==0)
       {
           removedNode=head;
           this.head = ptr.getNext(); // Changed head
           this.listSize--;
           return removedNode;
       }
       while(ptr.getNext()!=null && !(ptr.getNext().getData().compareTo(data)==0 )){
           ptr=ptr.getNext();
       }
       if(ptr.getNext()!=null && ptr.getNext().getData().compareTo(data)==0){
           removedNode=ptr.getNext();
           ptr.setNext((ptr.getNext()).getNext());
           this.listSize--;
           return removedNode;
       } else if(ptr.getNext()==null && ptr.getData().compareTo(data)==0) {
           removedNode=ptr;
           this.listSize--;
           ptr=null;
       } else {
          removedNode=null;
       }
       return removedNode;
   }
   
   //remove a node by its position
   public SinglyLinkListNode<T> removeByPosition(int position) {
       if(position<1 || position>this.listSize) {
           throw new IllegalArgumentException();
       }
       SinglyLinkListNode<T> removedNode = null;
       SinglyLinkListNode<T> ptr=head;
       int counter=1;
       if(position==1){
           head=ptr.getNext();
           this.listSize--;
           return ptr;
       }
       while(ptr.getNext()!=null && counter<position-1){
           ptr=ptr.getNext();
           counter++;
       }
       if(ptr.getNext()==null && counter==position) {
           removedNode=ptr;
           this.listSize--;
           ptr=null;
       } else if(counter==position-1){
           removedNode=ptr.getNext();
           ptr.setNext(ptr.getNext().getNext());
           this.listSize--;
       }
       return removedNode;
   }
   
   //reverses the list and stores it in original list
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
   
   /*
    * Sorting methods
    */
   //method to merge sorted sublist
   private SinglyLinkListNode<T> sortedMerge(SinglyLinkListNode<T> leftSublist, SinglyLinkListNode<T> rightSublist) {
       SinglyLinkListNode<T> result = null;
       if (leftSublist == null)
           return rightSublist;
       if (rightSublist == null)
           return leftSublist;
       if( leftSublist.getData().compareTo(rightSublist.getData())<0) {
           result = leftSublist;
           result.setNext (sortedMerge(leftSublist.getNext(), rightSublist));
       } else {
           result = rightSublist;
           result.setNext(sortedMerge(leftSublist, rightSublist.getNext()));
       }
       return result;
   }
   // splits the lsit and calls sorted merge
   public SinglyLinkListNode<T> mergeSort(SinglyLinkListNode<T> headptr) {
       if (headptr == null || headptr.getNext() == null) {
           return headptr;
       }
       SinglyLinkListNode<T> middle = getMiddle(headptr);
       SinglyLinkListNode<T> nextofmiddle = middle.getNext();
       middle.setNext(null);
       // Apply mergeSort on left list
       SinglyLinkListNode<T> left = mergeSort(headptr);
       // Apply mergeSort on right list
       SinglyLinkListNode<T> right = mergeSort(nextofmiddle);
       // Merge the left and right lists
       SinglyLinkListNode<T> sortedlist = sortedMerge(left, right);
       return sortedlist;
   }

   // Utility function to get the middle of the linked list
   private SinglyLinkListNode<T> getMiddle(SinglyLinkListNode<T> headPtr) {
       if (headPtr == null)
           return headPtr;
       SinglyLinkListNode<T> fastptr = headPtr.getNext();
       SinglyLinkListNode<T> slowptr = headPtr;  
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
   
   //displays the list to console
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