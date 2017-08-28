package com.metacube.Queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
    QueueCollection<Object> queueCollection;
    @Before
    public void initiate() {
        queueCollection = new QueueCollection<Object>();
    }
    
    @Test
    public void enqueueTest() {
        queueCollection.enqueue(1);
        queueCollection.enqueue("gaurav");
        assertFalse(queueCollection.isEmpty());
    }
    
    @Test
    public void dequeueTest() {
        queueCollection = new QueueCollection<Object>();
        queueCollection.enqueue(1);
        queueCollection.enqueue("gaurav");
        Object dequeuedObject;
        try {
            dequeuedObject = queueCollection.dequeue();
            assertEquals(1,dequeuedObject);
        } catch (QueueUnderFlowException e) {
            e.printStackTrace();
        }
        
    }
    
    @Test(expected=QueueUnderFlowException.class)
    public void dequeExceptionTest() throws QueueUnderFlowException {
        queueCollection = new QueueCollection<Object>();
        queueCollection.enqueue(1);
        queueCollection.dequeue();
        queueCollection.dequeue();
    }
}
