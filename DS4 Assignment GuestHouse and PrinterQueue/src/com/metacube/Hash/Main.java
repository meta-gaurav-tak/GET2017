package com.metacube.Hash;

import java.util.Scanner;


/**
 * Main class to initialize the room allotment in guest house.
 * 
 * @author Gaurav Tak
 */
public class Main {
   
    public static void main(String[] args) {
        String guestName;
        int guestAge;
        int noOfGuests;
        Guest guest;
        GuestHouse metaGuestHouse = new GuestHouse(10);
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter no. of guests : ");
        noOfGuests = getIntegerInput(scan);
        // Checks if the number of guests is greater than the number of rooms available.
        if (noOfGuests > metaGuestHouse.getTotalRoomsInGuestHouse()) {
            System.out.println("Room are available for only " + metaGuestHouse.getTotalRoomsInGuestHouse()
                    + " people !\n Want to continue with lesser guests ");
            if (!(scan.next().charAt(0)=='y') ) {
                System.out.println("Thank You.");
                System.exit(0);
            } else {
                noOfGuests = metaGuestHouse.getTotalRoomsInGuestHouse();
            }
        }
        // Gets the name and age of each guest.
        for (int count = 0; count < noOfGuests; count++) {
            System.out.println("Enter the Guest's name : ");
            guestName = scan.next();
            System.out.println("Enter the Guest's age : ");
            guestAge = getIntegerInput(scan);
            guest = new Guest(guestName, guestAge);
            try {
                metaGuestHouse.hashedRoomNo(guest);
            } catch (GuestHouseFullException e) {
                e.printStackTrace();
                System.out.println("No More Accomodation Possible in guest House : Guest House Full");
                System.exit(0);
            }
        }   
        // Displays the room alloted to the guests.
        for (int key : metaGuestHouse.getHashtable().keySet()) {
            System.out.println(metaGuestHouse.getHashtable().get(key).getName() + " with age " +
                    metaGuestHouse.getHashtable().get(key).getAge()+" is allocated the Room No :" 
                    + metaGuestHouse.getHashtable().get(key).getAllotedRoom());
        }
    }
    
    /**
     * Helps to take only integer value from the user.
     * 
     * @param scan    Scanner object.
     * @return the integer input.
     */
    public static int getIntegerInput(Scanner scan) {
        int input = 0;
        boolean flag = true;
        do {
            try {
                input = Integer.parseInt(scan.next());
                // Check if the input is not integer or less than 0.
                if(String.class.isInstance(input) || input < 1) {
                    throw new NumberFormatException();
                }
                flag = false;
            } 
            catch (NumberFormatException exception) {
                System.out.println("Please enter proper positive ineger value !");
            }
        } while (flag);
        
        return input;
    }
}
