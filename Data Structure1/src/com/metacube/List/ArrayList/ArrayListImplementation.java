package com.metacube.List.ArrayList;

import java.util.Arrays;
 
public class ArrayListImplementation<T> {
 
    private T[] arrayObject;
    private int actualSize = 0;
    public int getActualSize() {
        return actualSize;
    }
    public void setActualSize(int actualSize) {
        this.actualSize = actualSize;
    }


    private static final int DEFAULT_CAPACITY = 10;
     
    @SuppressWarnings("unchecked")
	public ArrayListImplementation(){
        arrayObject = (T[]) new Object[DEFAULT_CAPACITY];
    }
    public T get(int index){
        if(index < actualSize){
            return arrayObject[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public int retrieve(T obj){
        int indexer=0;
        while(indexer<actualSize){
            if(arrayObject[indexer].equals(obj)){
            return indexer;
            }else{
                indexer++;
            }
        }
        return -1;          // if obj is not found
    }
    
    public int retrieve(T obj,int location){
        int indexer=location;
        while(indexer<actualSize){
            if(arrayObject[indexer].equals(obj)){
            return indexer;
            }else{
                indexer++;
            }
        }
        return -1;          // if obj is not found
    }
    
    public void add(T obj){
        if(arrayObject.length-actualSize <= 2){
            ensureCapacity();
        }
        arrayObject[actualSize++] = obj;
    }
    public void add(T obj,int index){
        if(actualSize+1>=arrayObject.length){
            ensureCapacity();
        }
        if(index < actualSize && index>=0){
            int tmp = actualSize;
            while(tmp > index){
                arrayObject[tmp] = arrayObject[tmp-1];
                tmp--;
            }
            arrayObject[index] = obj;
            actualSize++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public T remove(int index){
        if(index < actualSize && index>=0){
            T obj = arrayObject[index];
            arrayObject[index] = null;
            int tmp = index;
            while(tmp < actualSize){
                arrayObject[tmp] = arrayObject[tmp+1];
                arrayObject[tmp+1] = null;
                tmp++;
            }
            actualSize--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
         
    }
     
    public int size(){
        return actualSize;
    }
    
    public int capacity(){
        return arrayObject.length;
    }
    private void ensureCapacity(){
        arrayObject = Arrays.copyOf(arrayObject, arrayObject.length*2);
    }
    
    @SuppressWarnings("unchecked")
	public void sort(){
        T[] sortedSubarray=(T[])Arrays.copyOfRange(arrayObject, 0, actualSize);
        Arrays.sort(sortedSubarray);
        this.arrayObject = (T[])new Object[this.capacity()];
        for(int index=0;index<actualSize;index++){
          this.arrayObject[index]=sortedSubarray[index];
        }
    }
    
    @SuppressWarnings("unchecked")
	public void reverse() {
        T[] reverse = (T[]) new Object[arrayObject.length];
        for (int i = 0, j = actualSize-1; i < actualSize; i++, j--) {
           reverse[j] = arrayObject[i];
        }
        this.arrayObject=reverse;
     }

	
	public void addList(ArrayListImplementation<T> list) {
		while(actualSize == arrayObject.length || (arrayObject.length - actualSize) < list.actualSize ) {
			ensureCapacity();
		}
		for(int listIndex = 0, elementsIndex = this.actualSize; listIndex < list.actualSize; listIndex++, elementsIndex++) {
		this.arrayObject[elementsIndex] = (T)list.get(listIndex);
		this.actualSize++;
		}
	}
    /*public static void main(String a[]){
        ArrayListImplementation<Integer> mal = new ArrayListImplementation<Integer>();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        ArrayListImplementation<Integer> mal2 = new ArrayListImplementation<Integer>();
        mal2.add(new Integer(3));
        mal2.add(new Integer(8));
        mal2.add(new Integer(19));
        mal2.add(new Integer(2));
        mal2.add(new Integer(14));
        mal.addList(mal2);
       
        mal.add(new Integer(29),3);
        
        //System.out.println("List size: "+mal.size());
        //mal.sort();
        //mal.reverse();
        
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
        System.out.println(mal.capacity());
    }*/
}