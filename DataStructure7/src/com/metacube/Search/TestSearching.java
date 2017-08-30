package com.metacube.Search;

import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TestSearching {
    SearchFacade facadeObject;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Before
    public void initialize() {
        facadeObject = new SearchFacade();
    }
    
    @Test
    public void testSearchInIntegerArray() {
        Integer[] array = new Integer[] {8,5,7,9,0,8,5,7,3};
        int actualSearchedIndex;
        try {
            actualSearchedIndex = facadeObject.search(7,array);
            assertEquals(2, actualSearchedIndex);
        } catch (SearchElementTypeMismatchException e) {
            e.getMessage();
        }
        
    }
    
    @Test
    public void testSearchInStringArray() {
        String[] array = new String[] {"Ramesh","Rohit","Rehan","Salil","Ramesh","Rehan"};
        int actualSearchedIndex;
        try {
            actualSearchedIndex = facadeObject.search("Ramesh",array);
            assertEquals(0, actualSearchedIndex);
        } catch (SearchElementTypeMismatchException e) {
            e.getMessage();
        }
        
    }
    
    @Test
    public void testSearchInIntegerArrayNotFound() {
        Integer[] array = new Integer[] {8,5,7,9,0,8,5,7,3};
        int actualSearchedIndex;
        try {
            actualSearchedIndex = facadeObject.search(15,array);
            assertEquals(-1, actualSearchedIndex);
        } catch (SearchElementTypeMismatchException e) {
            e.getMessage();
        }
        
    }
    @Test
    public void testSearchInStringArrayNotFound() {
        String[] array = new String[] {"Ramesh","Rohit","Rehan","Salil","Ramesh","Rehan"};
        int actualSearchedIndex;
        try {
            actualSearchedIndex = facadeObject.search("Ram",array);
            assertEquals(-1, actualSearchedIndex);
        } catch (SearchElementTypeMismatchException e) {
            e.getMessage();
        }
        
    }
    
    @Test
    public void testSearchException() throws SearchElementTypeMismatchException {
        thrown.expect(SearchElementTypeMismatchException.class);
        thrown.expectMessage("Search Element Type Different From Actual Array");
        Integer[] array = new Integer[] {8,5,7,9,0,8,5,7,3};
        int actualSearchedIndex;
            actualSearchedIndex = facadeObject.search("Ramesh",array);
            assertEquals(2, actualSearchedIndex);
    }
    
    @Test
    public void testSearchExceptionUsingTryCatch() {
        Integer[] array = new Integer[] {8,5,7,9,0,8,5,7,3};
            try {
                facadeObject.search("Ramesh",array);
                fail("Expected a SearchElementTypeMismatchException to be thrown");
            } catch (SearchElementTypeMismatchException e) {
                assertEquals(e.getMessage(),"Search Element Type Different From Actual Array");
            }
    }
    @Test
    public void testNullExceptionUsingTryCatch() {
        Integer[] array = new Integer[] {8,5,7,9,0,8,5,7,3};
            try {
                facadeObject.search(null,array);
                fail("Expected a IllegalArgumentException to be thrown");
            } catch (IllegalArgumentException e) {
                assertEquals(e.getMessage(),"Any/All of the parameters is/are found null");
            } catch (SearchElementTypeMismatchException e) {
                e.printStackTrace();
            }
    }
}
