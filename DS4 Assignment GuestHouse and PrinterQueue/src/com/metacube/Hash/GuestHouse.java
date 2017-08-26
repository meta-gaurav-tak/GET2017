package com.metacube.Hash;

import java.util.Hashtable;

/**
 * Class to generate a unique room for each guest and allot it to the guest.
 * 
 * @author Gaurav Tak
 */
public class GuestHouse {
    private int totalRoomsInGuestHouse;
    private int currentlyAvailableNumberOfRooms;
    public int getTotalRoomsInGuestHouse() {
        return totalRoomsInGuestHouse;
    }

    public void setTotalRoomsInGuestHouse(int totalRoomsInGuestHouse) {
        this.totalRoomsInGuestHouse = totalRoomsInGuestHouse;
    }

    public GuestHouse(int totalRoomsInGuestHouse) {
        this.totalRoomsInGuestHouse = totalRoomsInGuestHouse;
        this.currentlyAvailableNumberOfRooms = totalRoomsInGuestHouse;
    }
    
    public int getCurrentlyAvailableNumberOfRooms() {
        return currentlyAvailableNumberOfRooms;
    }

    public void setCurrentlyAvailableNumberOfRooms(
            int currentlyAvailableNumberOfRooms) {
        this.currentlyAvailableNumberOfRooms = currentlyAvailableNumberOfRooms;
    }

    public Hashtable<Integer, Guest> getHashtable() {
        return hashtable;
    }

    public void setHashtable(Hashtable<Integer, Guest> hashtable) {
        this.hashtable = hashtable;
    }

    // Number used to generate hash function.
    public static final int PRIME = 17;
    private int incrementer = 1;
    // Hash table consisting details of guests and room alloted to them.
    public Hashtable<Integer, Guest> hashtable = new Hashtable<Integer, Guest>();
    
    /**
     * Generates the unique room number for each guest.
     * 
     * @param guest    Guest class object
     * @throws GuestHouseFullException 
     */
    public int hashedRoomNo(Guest guest) throws GuestHouseFullException {
        if(currentlyAvailableNumberOfRooms <= 0) {
            System.out.println("No rooms Available in Guest House : Thanks for visting");
            throw new GuestHouseFullException();
        }
        int age = guest.getAge();
        int roomNo;
        // Generate unique room numbers using hash function.
        roomNo = ((age * + incrementer++) * PRIME) % this.totalRoomsInGuestHouse;
        // Check if the room number is already filled allot another room to the guest.
        while (hashtable.containsKey(roomNo+1)) {
            roomNo = (++roomNo) % this.totalRoomsInGuestHouse;
        }
        //adding 1 to room no value since a modulus by total room wiil give value from 0 to totalroom-1
        guest.setAllotedRoom(roomNo+1);
        hashtable.put(roomNo+1, guest);
        currentlyAvailableNumberOfRooms--;
        return roomNo+1;
    }
  
}

