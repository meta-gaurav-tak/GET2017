package com.metacube.Counselling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Allotment {
    private static Map<Integer,Integer> allotedCollege;
    private static QueuingApplication queuingApplication;
    List<Integer> recounsellingArray;
    int totalAvailableSeats = College.getTotalSeats();
    public void createCounsellingQueue() {
        allotedCollege = new TreeMap<Integer,Integer>();
        queuingApplication = new QueuingApplication();
        queuingApplication.generateCounsellingQueue();
    }
    
    
    public boolean allotCollege() {
        this.recounsellingArray = new ArrayList<Integer>();
        if(totalAvailableSeats <= 0 ) {
            System.out.println();
            System.out.println("All the seats have been alloted no counselling can take place further");
            System.out.println();
            return false;
        }
        if((Student)queuingApplication.studentQueue.getFront()==null) {
            System.out.println();
            System.out.println("All the candidates are either alloted a seat or have deferred counselling");
            System.out.println();
            return false;
        }
        Student candidate;
        // get candidates from queue and try to allot them a college
        while(totalAvailableSeats > 0 && (Student)queuingApplication.studentQueue.getFront()!=null) {   // until either queue or seats exhaust completely 
            candidate=(Student)queuingApplication.studentQueue.dequeue();
            boolean allotmentFlag = false;
            for(int i=0;i < candidate.getCollegeChoice().length;i++) {
                int collegeIdToApply=candidate.getCollegeChoice()[i];
                
                //if a seat is vacant at preferred college; allot the seat and reduce one seat from available seats
                if(College.collegeMap.get(collegeIdToApply).getAvailableSeats() > 0){
                    College.collegeMap.get(collegeIdToApply).setAvailableSeats(
                            College.collegeMap.get(collegeIdToApply).getAvailableSeats()-1);
                    totalAvailableSeats--;
                    allotedCollege.put(candidate.getRank(),collegeIdToApply);       // allot the college to candidate
                    allotmentFlag = true;
                    break;           
                }
            }
            if(!allotmentFlag) {                                //if a dequeued candidate does not get any college, add him for re-counseling process 
                recounsellingArray.add(candidate.getRank());
            }
        }
        return true;
    }
    
    //regenerating the queue for next round counseling
    public void regenerateQueue() {
        queuingApplication = new QueuingApplication();
        Collections.sort(recounsellingArray);
        for(Integer rank : recounsellingArray) {
            queuingApplication.studentQueue.enqueue(Student.studentMap.get(rank));
        }
    }
    
    //method that confirms the alloted seats from candidate and if not accepted are given a choice to upward movement
    public void confirmSeatAcceptance() {
        List<Integer> candidateToRemoveFromMap=new ArrayList<Integer>();
        
        for(Integer candidateId : allotedCollege.keySet()) {
            Student candidate = Student.studentMap.get(candidateId);
            System.out.println(candidate.getName()+
                    ", do you accept your alloted seat at "+
                    College.collegeMap.get(allotedCollege.get(candidateId)).getCollegeName() + " (Yes/No) ");
            Scanner input = new Scanner(System.in);
            String choice;
            do {
                choice = input.next();
                if(choice.charAt(0) == 'N' || choice.charAt(0) == 'n') {        
                    College receivedCollege = College.collegeMap.get(allotedCollege.get(candidateId));
                    receivedCollege.setAvailableSeats( receivedCollege.getAvailableSeats()+1);
                    totalAvailableSeats++;
                    if(receivedCollege.getId() != (Student.studentMap.get(candidateId)).getCollegeChoice()[0]) {       // check if candidate got topmost preference college
                        
                        //Asking if interested for Upward Movement
                        System.out.println("Want To apply for Upward Movement ( Yes/No )");
                        String choiceUpwardMovement;
                        do{
                            choiceUpwardMovement = input.next();
                            if(choiceUpwardMovement.charAt(0) == 'Y' || choiceUpwardMovement.charAt(0) == 'y') {
                                recounsellingArray.add(candidateId);
                                System.out.println();
                                System.out.println("Your current allotment is now abandoned and Status for Re-Counselling : True");
                                System.out.println();
                            } else if (choiceUpwardMovement.charAt(0) == 'N' || choiceUpwardMovement.charAt(0) == 'n') {
                                System.out.println();
                                System.out.println("Your allotment is now abandoned and Status for Re-Counselling : False");
                                System.out.println();
                            } else {
                                System.out.println();
                                System.out.println("Enter your choice in valid format (Yes or No) only");
                                System.out.println();
                            }
                        }while(choiceUpwardMovement.charAt(0) != 'N' && choiceUpwardMovement.charAt(0) != 'n' 
                                && choiceUpwardMovement.charAt(0) != 'Y' && choiceUpwardMovement.charAt(0) != 'y');
                    } else {
                        System.out.println();
                        System.out.println("You rejected your top most College preferance : Denied counselling process further");
                        System.out.println();
                    }
                    candidateToRemoveFromMap.add(candidateId);
                    
                } else if (choice.charAt(0) == 'Y' || choice.charAt(0) == 'y') {
                    candidateToRemoveFromMap.add(candidateId);
                    System.out.println("You locked your seat at alloted college : Hope to see you soon! ");
                    System.out.println();
                } else {
                    System.out.println("Please enter choice in yes or no format ");
                }
            }while(choice.charAt(0) != 'N' && choice.charAt(0) != 'n' && choice.charAt(0) != 'Y' && choice.charAt(0) != 'y');
        }
        for(Integer candidateId : candidateToRemoveFromMap ) {
            allotedCollege.remove(candidateId);
        }
        while((queuingApplication.studentQueue.getFront()!=null)) {
            Student student = (Student) queuingApplication.studentQueue.dequeue();
            recounsellingArray.add(student.getRank());
        }
        regenerateQueue();  // to regenerate queue for later round counseling
        System.out.println();
        System.out.println("After This Round Counselling Total Available Seats for Recounselling : " + totalAvailableSeats);
        System.out.println();
    }
    
    //Display the candidate who got a college with alloted college name
    public void displayAllotedCollege() {
        System.out.format("%-32s %-32s","StudentName","AllotedCollege ");
        System.out.println();
        System.out.println();
        for(Integer key : allotedCollege.keySet()){
            System.out.format("%-32s %-32s",Student.studentMap.get(key).getName(),
                    College.collegeMap.get(allotedCollege.get(key)).getCollegeName());
            System.out.println();
        }
        
    }
    
}
