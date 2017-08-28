package com.metacube.LinkList;

import java.util.LinkedList;
import java.util.List;

public class SortedLikList<E extends Comparable<E>> {
    private List<E> sortedList; //the sorted list object
    public List<E> getSortedList() {
        return sortedList;
    }

    public void setSortedList(List<E> sortedList) {
        this.sortedList = sortedList;
    }
    
    public SortedLikList() {
        sortedList = new LinkedList<E>();
    }

    //adds to the correct position in sorted order of list
    public boolean add(E data) {
        if(this.getIndexToAdd(data,0) == this.sortedList.size() ) {
            sortedList.add(data);
            return true;
        } else {
            sortedList.add(getIndexToAdd(data,0),data);
            return true;
        }
    }
    
    //return the correct index for an object in the sorted order
    private int getIndexToAdd(E data,int currentPosition) {
        if(this.sortedList.size() == currentPosition) {
            return currentPosition;
        }else {
            E currentElement = sortedList.get(currentPosition);
            if(currentElement.compareTo(data) < 0) {
                currentPosition++;
                return getIndexToAdd(data,currentPosition);
            } else {
                return currentPosition;
            }
        }
    }
    
    public static void main(String args[]) {
        SortedLikList<Integer> sll = new SortedLikList<Integer>();
        sll.add(1);
        sll.add(5);
        
        sll.add(3);
        sll.add(1);
        sll.add(7);
        sll.add(0);
        sll.add(-1);
        sll.add(-5);
        
        for(Integer element : sll.getSortedList()) {
            System.out.println(element);
        }
    }
}
