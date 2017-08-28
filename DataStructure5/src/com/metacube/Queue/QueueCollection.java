package com.metacube.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueCollection<E> {
    Queue<E> queue ;
    
    public QueueCollection() {
        this.queue = new LinkedList<E>();
    }
    
    public void enqueue(E data) {
        queue.add(data);
    } 
    //to remove an element from queue
    public E dequeue() throws QueueUnderFlowException {
        try {
            return queue.remove();
        } catch(NoSuchElementException e) {
            System.out.println("Queue UnderFlow : Nothing to Dequeue");
            throw new QueueUnderFlowException();
        }
    }
    //to get front of queue without removing it
    public E getFront() throws QueueUnderFlowException {
        try {
            return queue.element();
        } catch(NoSuchElementException e) {
            System.out.println("Queue UnderFlow : Nothing to Dequeue");
            throw new QueueUnderFlowException();
        }
    }
    
    //to empty the queue
    public void makeEmpty() {
        queue.clear();
    }
    
    public boolean isEmpty() {
        if(queue.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String args[]) {
        QueueCollection<Integer> newQueue = new QueueCollection<Integer>();
        newQueue.enqueue(123);
        try {
            System.out.println(newQueue.dequeue());
            System.out.println(newQueue.dequeue());
            newQueue.makeEmpty();
            System.out.println(newQueue.getFront());
        }catch (QueueUnderFlowException e) {
        }
        newQueue.enqueue(123);
        newQueue.enqueue(44);
        try {
            System.out.println(newQueue.getFront());
        } catch (QueueUnderFlowException e) {
            e.printStackTrace();
        }
    }
    
}