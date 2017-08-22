package com.metacube.List.DoublyLinkList;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.List.DoublyLinkList.DoublyLinkListNode;
import com.metacube.List.DoublyLinkList.DoublyLinkedList;

public class DoublyLinkListTest {
DoublyLinkedList<Integer> doublyLinkListObject;
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void addElementToListByPositionExceptionTest(){
        doublyLinkListObject=new DoublyLinkedList<Integer>();
        doublyLinkListObject.addAtPosition(5, 9);
    }
    
    @Test
    public void addElementToListAtStart() {
        doublyLinkListObject=new DoublyLinkedList<Integer>();
        doublyLinkListObject.addAtPosition(7,1);
        
    }
    @Test
    public void addElementToListTestConsecutiveAddition() {
        doublyLinkListObject=new DoublyLinkedList<Integer>();
        boolean addFlag=false;
        for(int i=0;i<10;i++){
            addFlag = doublyLinkListObject.addAtPosition(new Integer(i), i+1);
        }
        assertEquals(true,addFlag);
    }
    @Test
    public void removeByValueTest() {
        doublyLinkListObject=new DoublyLinkedList<Integer>();
        doublyLinkListObject.addAtPosition(7,1);
        doublyLinkListObject.addAtPosition(8,1);
        DoublyLinkListNode<Integer> removedNode=doublyLinkListObject.removeByValue(8);
        assertEquals(removedNode.getData(),new Integer(8));
    }
    @Test
    public void removeByPostionTest() {
        doublyLinkListObject=new DoublyLinkedList<Integer>();
        doublyLinkListObject.addAtPosition(7,1);
        doublyLinkListObject.addAtPosition(8,2);
        DoublyLinkListNode<Integer> removedNode = doublyLinkListObject.removeByPosition(2);
        assertEquals(removedNode.getData(),new Integer(8));
    }
    @Test
    public void reverseTest() {
        doublyLinkListObject=new DoublyLinkedList<Integer>();
        doublyLinkListObject.addAtPosition(7,1);
        doublyLinkListObject.addAtPosition(9,2);
        doublyLinkListObject.addAtPosition(1,3);
        doublyLinkListObject.addAtPosition(5,4);
        doublyLinkListObject.addAtPosition(0,5);
        doublyLinkListObject.reverseList();
        DoublyLinkedList<Integer> doublyLinkListObject2=new DoublyLinkedList<Integer>();
        doublyLinkListObject2.addAtPosition(0,1);
        doublyLinkListObject2.addAtPosition(5,2);
        doublyLinkListObject2.addAtPosition(1,3);
        doublyLinkListObject2.addAtPosition(9,4);
        doublyLinkListObject2.addAtPosition(7,5);
        
        DoublyLinkListNode<Integer> ptr=doublyLinkListObject.getHead();
        DoublyLinkListNode<Integer> ptr2=doublyLinkListObject.getHead();
        for(;ptr!=null && ptr2!=null;ptr=ptr.getNext(),ptr2=ptr2.getNext()) {
            assertEquals(ptr.getData(),ptr2.getData());
        }     
    }
}
