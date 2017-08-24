package com.metacube.Stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {
    StackImplementation stack;
    @Test
    public void pushToEmptyTest() {
        stack = new StackImplementation();
        boolean pushFlag = stack.push("ramesh");
        assertEquals(true,pushFlag);
    }
    @Test
    public void pushMultipleTest() {
        stack = new StackImplementation();
        boolean pushFlag = stack.push("ramesh");
        pushFlag = stack.push(12);
        pushFlag = stack.push(2.0);
        assertEquals(true,pushFlag);
    }
    @Test(expected = IllegalArgumentException.class)
    public void pushExceptionTest() {
        stack = new StackImplementation();
        stack.push(null);
    }
    
    @Test
    public void testEmptyPop() {
        stack = new StackImplementation();
        Object removed = stack.pop();
        assertEquals(null,removed);
    }
    @Test
    public void testPop() {
        stack = new StackImplementation();
        stack.push("ramesh");
        stack.push(12);
        stack.push("rohit");
        Object removed = stack.pop();
        assertEquals("rohit",removed);
    }
    @Test
    public void testPeep() {
        stack = new StackImplementation();
        stack.push("ramesh");
        stack.push(12);
        stack.push("rohit");
        Object top = stack.peep();
        assertEquals("rohit",top);
    }
}
