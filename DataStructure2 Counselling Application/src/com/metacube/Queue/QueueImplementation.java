package com.metacube.Queue;

import java.util.ArrayList;
import java.util.List;

public class QueueImplementation {
    private int front;
    private int rear;
    private List<Object> queue;
    public QueueImplementation() {
        front = -1;
        rear = -1;
        queue = new ArrayList<Object>();
    }
    public QueueImplementation(List<Object> queue) {
        this.queue = queue;
        this.front = 0;
        this.rear = queue.size()-1;
    }
    public List<Object> getQueue() {
        return queue;
    }
    public void setQueue(List<Object> queue) {
        this.queue = queue;
        this.front = 0;
        this.rear = queue.size()-1;
    }

    public void setFront(int front) {
        this.front = front;
    }
    public int getRear() {
        return rear;
    }
    public void setRear(int rear) {
        this.rear = rear;
    }
    
    //method to add an object to a queue
    public boolean enqueue(Object data) {
        if(data != null && data != ""){
            this.front = 0;
            this.queue.add((++this.rear), data);
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    //to remove an element from Queue
    public Object dequeue() {
        Object removedElement = null;
        if (this.rear == -1 ){
            return null;
        } else if(this.rear == this.front) {
            removedElement = queue.get(this.front);
            queue.remove(this.rear);
            this.rear--;
            this.front--;
        } else {
            removedElement = queue.get(this.front);
            for(int index=front;index <= this.rear-1;index++) {
                queue.set(index, queue.get(index+1));
            }
            queue.set(this.rear,null);
            this.rear--;
        }
        return removedElement;
    }
    
    //returns the object value at the front of queue 
    public Object getFront() {
        if(!isEmpty()) {
            return queue.get(this.front);
        } else {
            //System.out.println("Queue Empty : No item at Front");
            return null;
        }
    }
    
    public boolean isEmpty() {
        if (this.front == -1 || this.rear == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    //to display Queue content
    public void display() {
        if(!isEmpty()) {
            for(int index = front;index <= this.rear;index++){
                System.out.print(queue.get(index)+" <---");
            }
        } else {
            System.out.println("Queue Empty : No iitem at Front");
        }
    }
    
    //to make the queue empty
    public void makeEmpty() {
        this.queue.clear();
        this.front = -1;
        this.rear = -1;
    }
    
    /*public static void main(String args[]) {
        QueueImplementation queueObject=new QueueImplementation();
        queueObject.enqueue(12);
        queueObject.enqueue(10);
        queueObject.enqueue(1);
        System.out.println(queueObject.dequeue());
        //System.out.println(queueObject.getRear());
        System.out.println(queueObject.dequeue());
        //System.out.println(queueObject.getRear());
        System.out.println(queueObject.dequeue());
        //System.out.println(queueObject.getRear());
        queueObject.enqueue(12);
        queueObject.enqueue(10);
        queueObject.enqueue(1);
        //queueObject.makeEmpty();
        queueObject.display();
    }*/
    
}
