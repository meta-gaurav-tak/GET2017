package com.metacube.Concordance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class ConcordanceTest {
    
    Concordance concordance;
    @Before
    public void initiateConcordance() {
        concordance = new Concordance();
    }
    @Test
    public void concordanceTest1() {
        String input = "HelloGaurav";
        String actual = concordance.getConcordanceString(input);
        String expected = "G : [5]\t\tH : [0]\t\ta : [6, 9]\t\te : [1]\t\tl : [2, 3]\t\to : [4]\t\tr : [8]\t\tu : [7]\t\tv : [10]\t\t";
        
        assertEquals(expected, actual);
    }
    
    // Positive test case 2.
    @Test
    public void concordanceTest2() {
        String input = "WelcomeToMetacube";
        String actual = concordance.getConcordanceString(input);
        String expected = "M : [9]\t\tT : [7]\t\tW : [0]\t\ta : [12]\t\tb : [15]\t\tc : [3, 13]\t\te : [1, 6, 10, 16]\t\tl : [2]\t\tm : [5]\t\to : [4, 8]\t\tt : [11]\t\tu : [14]\t\t";
        assertEquals(expected, actual);
    }
    
    //Negative Test Case
    @Test
    public void concordanceTest4() {
        String input = "JaipurIsMyCity";
        String actual = concordance.getConcordanceString(input);
        String expected = "C : [10]    I : [6]    J : [0]    M : [8]    a : [1]    i : [2, 11]    p : [3]    r : [5]    s : [7]    t : [12]    u : [4]    y : [9, 13]        ";
        
        assertNotEquals(expected, actual);
    }
    
    
}
