package com.metacube.Heap;

import java.util.Arrays;

public class BinaryHeap <T extends Comparable> {
	public static  final int DEFAULT_CAPACITY = 20;
	private T[] heapArray;     //array that holds the heap 
	private int arraySize;     //no of nodes in heap
	public BinaryHeap() {
        heapArray = (T[]) new Comparable[DEFAULT_CAPACITY];
        arraySize=0;
    }
	public T[] getHeapArray() {
		return heapArray;
	}
	public void setHeapArray(T[] heapArray) {
		this.heapArray = heapArray;
	}
	public int getArraySize() {
		return arraySize;
	}
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	
	//inserting an element to heap and restoring max heap property
	public void insert(T object) {
	    if(arraySize+1 > heapArray.length) {
	        resizeHeapArray();
	    }
		heapArray[arraySize++] = object;
		heapifyUp(arraySize-1);
	}
	
	//to resize heap array to accommodate heap elements
	public void resizeHeapArray() {
	    heapArray = Arrays.copyOf(heapArray, heapArray.length + DEFAULT_CAPACITY);
	}
	
	//to restore heap property from child to parent
	public void heapifyUp(int index) {
		if(index<=0) {
			return;
		} else if( heapArray[index].compareTo(heapArray[(index-1)/2]) > 0) {
			swap(index,(index-1)/2);
			heapifyUp((index-1)/2);
		} else {
			return;
		}
	}
	
	//to remove the topmost heap node and restore heap property 
	public T delete() throws HeapEmptyException {
	    if(arraySize <= 0) {
	        throw new HeapEmptyException();
	    } else {
		T removedNode =heapArray[0];
		heapArray[0] = heapArray[arraySize-1];
		heapArray[arraySize-1] = null;
		arraySize--;
		heapifyDown(0);
		return removedNode;
	    }
	}
	
	//to restore max heap property from parent to child
	public void heapifyDown(int index) {
		if( (2*index + 1) >= arraySize) {
			return;
		} else if( heapArray[index].compareTo(heapArray[maxValueIndex(2*index+1,2*index+2)]) < 0) {
		    int index2swap = maxValueIndex(2*index+1,2*index+2);
			swap(index,index2swap);
			heapifyDown(index2swap);
		} else {
			return;
		}
	}
	
	// to get the index of the greater value from among two array elements
	public int maxValueIndex(int index1, int index2) {
		if(heapArray[index2] == null) {
			return index1;
		}
		if(heapArray[index1] == null) {
			return -1;
		}
		if(heapArray[index1].compareTo(heapArray[index2]) >= 0) {
			return index1;
		} else {
			return index2;
		}
	}
	
	//utility method to swap two array elements
	public void swap(int index1, int index2){
		T temp = heapArray[index1];
		heapArray[index1] = heapArray[index2];
		heapArray[index2] = (T) temp;
	}
	
	public void displayHeapArray() {
		for(int counter=0; counter < arraySize; counter++ ) {
			System.out.println(heapArray[counter] + " ");
		}
	}
	/*public static void main(String args[]) {
		BinaryHeap<Integer> bHeap = new BinaryHeap<Integer>();
		bHeap.insert(4);
		bHeap.insert(4);
		bHeap.insert(2);
		bHeap.insert(1);
		bHeap.insert(4);
		bHeap.insert(3);
		bHeap.insert(3);
		//bHeap.displayHeapArray();
		bHeap.insert(2);
		
		bHeap.insert(1);
		//bHeap.displayHeapArray();
		try{
		System.out.println(bHeap.delete());
		System.out.println(bHeap.delete());
		System.out.println(bHeap.delete());
		System.out.println(bHeap.delete());
		System.out.println(bHeap.delete());
        System.out.println(bHeap.delete());
        System.out.println(bHeap.delete());
        System.out.println(bHeap.delete());
        System.out.println(bHeap.delete());
        System.out.println(bHeap.delete());
		}catch(HeapEmptyException e) {
		    e.printStackTrace();
		}
	}*/
}
