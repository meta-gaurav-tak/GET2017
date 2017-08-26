package com.metacube.Hash;

public class Guest {
    private String name;
    private int age;
    private int allotedRoom; 
    public int getAllotedRoom() {
        return allotedRoom;
    }

    public void setAllotedRoom(int allotedRoom) {
        this.allotedRoom = allotedRoom;
    }

    public Guest() {
    }
    
    public Guest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
