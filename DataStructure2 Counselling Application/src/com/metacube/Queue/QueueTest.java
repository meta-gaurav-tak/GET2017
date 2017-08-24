package com.metacube.Queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
    QueueImplementation queueObject;
    @Before
    public void defineQueue() {
         queueObject = new QueueImplementation();
    }
    
    @Test
    public void EnqueueTest() {
        boolean addFlag = queueObject.enqueue(10);
        assertEquals(true,addFlag);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void EnqueueExceptionTest() {
        queueObject.enqueue(null);
    }
    
    @Test
    public void DequeTest() {
        queueObject.enqueue(10);
        queueObject.enqueue(12);
        queueObject.enqueue(19);
        Object removed = queueObject.dequeue();
        assertEquals(10,removed);
    }
    
    @Test
    public void DequeEmptyTest() {
        Object removed = queueObject.dequeue();
        assertEquals(null,removed);
    }
    
    @Test
    public void makeEmptyTest() {
        queueObject.enqueue(10);
        queueObject.enqueue(12);
        queueObject.enqueue(19);
        queueObject.makeEmpty();
        queueObject.display();
        Object front = queueObject.getFront();
        assertEquals(null,front);
    }
    @Test
    public void getFrontTest() {
        queueObject.enqueue(10);
        queueObject.enqueue(12);
        queueObject.enqueue(19);
        Object front = queueObject.getFront();
        assertEquals(10,front);
    }
}
