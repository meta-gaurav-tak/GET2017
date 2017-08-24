package com.metacube.Counselling;

import java.util.HashMap;
import java.util.Map;

public class College {
    private int id;
    private String collegeName;
    private int availableSeats;
    public College() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCollegeName() {
        return collegeName;
    }
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public static Map<Integer, College> getCollegeMap() {
        return collegeMap ;
    }
    public static void setCollegeMap(Map<Integer, College> collegeMap) {
        College.collegeMap = collegeMap;
    }
    public College(int id, String collegeName, int availableSeats) {
        this.id = id;
        this.collegeName = collegeName;
        this.availableSeats = availableSeats;
    }
    
    /* This method creates a map that acts as our Database*/
    public static Map<Integer,College> collegeMap;
    public static void constructCollegeMap() {
        collegeMap=new HashMap<Integer, College>();
        collegeMap.put(1,new College(1,"JECRC",3));
        collegeMap.put(2,new College(2,"SKIT",2));
        collegeMap.put(3,new College(3,"POORNIMA",3));
        collegeMap.put(4,new College(4,"GyanVihar",2));
        collegeMap.put(5,new College(5,"VIT",2));
    }
    
    public static int getTotalSeats() {
        int totalNoOfSeats = 0;
        if(collegeMap != null) {
            for(int collegeId : collegeMap.keySet()) {
                totalNoOfSeats += collegeMap.get(collegeId).getAvailableSeats();
            }
        }
        return totalNoOfSeats;
    }
}
