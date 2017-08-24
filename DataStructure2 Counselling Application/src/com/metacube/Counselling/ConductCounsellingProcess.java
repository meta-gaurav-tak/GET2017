package com.metacube.Counselling;

public class ConductCounsellingProcess {
    public static void createSingleRoundCounselling(String roundNumberString , Allotment allotment) {
        if(allotment.allotCollege()) {
            System.out.println("########-- "+roundNumberString+" Round Allotment List --####### ");
            System.out.println();
            allotment.displayAllotedCollege();
            //apply nth round counseling 
            System.out.println();
            System.out.println("Welcome to counselling process - "+roundNumberString+" Round");
            System.out.println();
            allotment.confirmSeatAcceptance();
            } else {
                System.exit(0);
            }
    }
}
