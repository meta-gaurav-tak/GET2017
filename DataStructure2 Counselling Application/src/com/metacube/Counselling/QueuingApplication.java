package com.metacube.Counselling;

import com.metacube.Queue.QueueImplementation;
/**
 * This class is designed to generate a queue for the counselling process
 * the elements are addded to the queue based on their rank 
 * @author Gaurav
 *
 */
public class QueuingApplication {
    public  QueueImplementation studentQueue = new QueueImplementation();
    public  void generateCounsellingQueue() {
        for(int index : Student.studentMap.keySet()) {
            this.studentQueue.enqueue(Student.studentMap.get(index));
        }
    }
}
