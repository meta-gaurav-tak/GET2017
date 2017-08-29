package com.metacube.UniqueCharacters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUniqueCharacters {
    UniqueCharactersCache cache;
    
    @Before
    public void initialize() {
        cache = new UniqueCharactersCache();
    }
    @Test
    public void testUniqueCharacterConsecutive() {
        int actual = cache.getNumberOfUniqueCharacters("aaaabb  cccd");
        assertEquals(5, actual);
    }
    @Test
    public void testUniqueCharacterNull() {
        int actual = cache.getNumberOfUniqueCharacters(null);
        assertEquals(-1,actual);
    }
    @Test
    public void testUniqueCharacterRepititive() {
        int actual = cache.getNumberOfUniqueCharacters("abcabcabc");
        assertEquals(3, actual);
    }
    @Test
    public void testUniqueCharacterNegative() {
        int actual = cache.getNumberOfUniqueCharacters("aaaabb11cccd");
        assertEquals(5, actual);
    }
}
