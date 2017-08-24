package com.metacube.Counselling;

public class Main {
    public static void main(String args[]) {
        College.constructCollegeMap();          //populate the college map 
        Student.populateStudentMap();           //populate the student map
        Allotment allotment = new Allotment();  // create a new allotment  
        allotment.createCounsellingQueue();
        
        
        //get first round allotment result
        ConductCounsellingProcess.createSingleRoundCounselling("First", allotment);
        
        //get second round seat allotment
        ConductCounsellingProcess.createSingleRoundCounselling("Second", allotment);
        
        // 3rd round counseling
        ConductCounsellingProcess.createSingleRoundCounselling("Third", allotment);
        //4rth round counseling
        ConductCounsellingProcess.createSingleRoundCounselling("Forth", allotment);
    }
}
