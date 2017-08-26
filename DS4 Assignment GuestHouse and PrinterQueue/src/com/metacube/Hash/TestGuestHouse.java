package com.metacube.Hash;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

public class TestGuestHouse {

    private GuestHouse metaGuestHouse;

    @Before
    public void initHash() {
        metaGuestHouse = new GuestHouse(20);
    }

    @Test
    public void testHashedRoomNoSameAgeGuest() {
        try {
        Guest guest1 = new Guest("Ramesh",22);
        guest1.setAllotedRoom(metaGuestHouse.hashedRoomNo(guest1));
        Guest guest2 = new Guest("Rahul",22);
        guest2.setAllotedRoom(metaGuestHouse.hashedRoomNo(guest2));
        assertNotEquals(guest1.getAllotedRoom(), guest2.getAllotedRoom());
        } catch(GuestHouseFullException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testHashedRoomNoDifferentAgeGuest() {
        try {
        Guest guest1 = new Guest("Ramesh",22);
        guest1.setAllotedRoom(metaGuestHouse.hashedRoomNo(guest1));
        Guest guest2 = new Guest("Rahul",25);
        guest2.setAllotedRoom(metaGuestHouse.hashedRoomNo(guest2));
        assertNotEquals(guest1.getAllotedRoom(), guest2.getAllotedRoom());
        } catch(GuestHouseFullException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void ensureAllGuestInHashTable() {
        try {
        Guest guest1 = new Guest("Ramesh",22);
        guest1.setAllotedRoom(metaGuestHouse.hashedRoomNo(guest1));
        Guest guest2 = new Guest("Rahul",25);
        guest2.setAllotedRoom(metaGuestHouse.hashedRoomNo(guest2));
        Guest guest3 = new Guest("Ramesh",22);
        guest3.setAllotedRoom(metaGuestHouse.hashedRoomNo(guest3));
        Guest guest4 = new Guest("Rahul",25);
        guest4.setAllotedRoom(metaGuestHouse.hashedRoomNo(guest4));
        assertTrue(metaGuestHouse.getHashtable().containsValue(guest1));
        assertTrue(metaGuestHouse.getHashtable().containsValue(guest2));
        assertTrue(metaGuestHouse.getHashtable().containsValue(guest3));
        assertTrue(metaGuestHouse.getHashtable().containsValue(guest4));
        } catch(GuestHouseFullException e) {
            e.printStackTrace();
        }
    }
    
    //ask how to make this work 
    
    /*@Test(expected = GuestHouseFullException.class)
    public void testGuestHouseFullException() {
        GuestHouse smallGuestHouse = new GuestHouse(4);
        try {
        Guest guest1 = new Guest("Ramesh",22);
        guest1.setAllotedRoom(smallGuestHouse.hashedRoomNo(guest1));
        Guest guest2 = new Guest("Rahul",25);
        guest2.setAllotedRoom(smallGuestHouse.hashedRoomNo(guest2));
        Guest guest3 = new Guest("Ramesh",22);
        guest3.setAllotedRoom(smallGuestHouse.hashedRoomNo(guest3));
        Guest guest4 = new Guest("Rahul",25);
        guest4.setAllotedRoom(smallGuestHouse.hashedRoomNo(guest4));
        }catch (GuestHouseFullException e) {
            
        }
        Guest guest5 = new Guest("Rahul",25);
        smallGuestHouse.hashedRoomNo(guest5);
    }*/
}
