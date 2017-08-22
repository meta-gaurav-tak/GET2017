package com.metacube.List.SinglyLinkList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class SinglyLinkListTest {
    SinglyLinkedList<Integer> singlyLinkListObject;
    
    @Test(expected=IllegalArgumentException.class)
    public void addElementToListByPositionExceptionTest(){
        singlyLinkListObject=new SinglyLinkedList<Integer>();
        singlyLinkListObject.addAtPosition(5, 9);
    }
    
    @Test
    public void addElementToListAtStart() {
        singlyLinkListObject=new SinglyLinkedList<Integer>();
        singlyLinkListObject.addAtPosition(7,1);
        
    }
    @Test
    public void addElementToListTestConsecutiveAddition() {
        singlyLinkListObject=new SinglyLinkedList<Integer>();
        boolean addFlag=false;
        for(int i=0;i<10;i++){
            addFlag = singlyLinkListObject.addAtPosition(new Integer(i), i+1);
        }
        assertEquals(true,addFlag);
    }
    @Test
    public void removeByValueTest() {
        singlyLinkListObject=new SinglyLinkedList<Integer>();
        singlyLinkListObject.addAtPosition(7,1);
        singlyLinkListObject.addAtPosition(8,1);
        SinglyLinkListNode<Integer> removedNode=singlyLinkListObject.removeByValue(8);
        assertEquals(removedNode.getData(),new Integer(8));
    }
    @Test
    public void removeByPostionTest() {
        singlyLinkListObject=new SinglyLinkedList<Integer>();
        singlyLinkListObject.addAtPosition(7,1);
        singlyLinkListObject.addAtPosition(8,2);
        SinglyLinkListNode<Integer> removedNode = singlyLinkListObject.removeByPosition(2);
        assertEquals(removedNode.getData(),new Integer(8));
    }
    @Test
    public void reverseTest() {
        singlyLinkListObject=new SinglyLinkedList<Integer>();
        singlyLinkListObject.addAtPosition(7,1);
        singlyLinkListObject.addAtPosition(9,2);
        singlyLinkListObject.addAtPosition(1,3);
        singlyLinkListObject.addAtPosition(5,4);
        singlyLinkListObject.addAtPosition(0,5);
        singlyLinkListObject.reverse(singlyLinkListObject.getHead());
        SinglyLinkedList<Integer> singlyLinkListObject2=new SinglyLinkedList<Integer>();
        singlyLinkListObject2.addAtPosition(0,1);
        singlyLinkListObject2.addAtPosition(5,2);
        singlyLinkListObject2.addAtPosition(1,3);
        singlyLinkListObject2.addAtPosition(9,4);
        singlyLinkListObject2.addAtPosition(7,5);
        
        SinglyLinkListNode<Integer> ptr=singlyLinkListObject.getHead();
        SinglyLinkListNode<Integer> ptr2=singlyLinkListObject.getHead();
        for(;ptr!=null && ptr2!=null;ptr=ptr.getNext(),ptr2=ptr2.getNext()) {
            assertEquals(ptr.getData(),ptr2.getData());
        }     
    }
}
