package com.metacube.Stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {
    @Test
    public void testNonParenthesizedNumbericalExpression() {
        String infix = "54+46+45+46+465+45-44*55/5+89";
        InfixToPostfix i2p = new InfixToPostfix();
        String postfix=i2p.toPostFix(infix);
        String expectedPostfix="5446+45+46+465+45+4455*5/-89+";
        assertEquals(expectedPostfix,postfix);
        
    }
    @Test
    public void testNonParenthesizedExpression() {
        String infix = "A+B*C/D-E*F";
        InfixToPostfix i2p = new InfixToPostfix();
        String postfix=i2p.toPostFix(infix);
        String expectedPostfix="ABC*D/+EF*-";
        assertEquals(expectedPostfix,postfix);
        
    }
    @Test
    public void testParenthesizedNumbericalExpression() {
        String infix = "(54*13)+9-7*(4/6)";
        InfixToPostfix i2p = new InfixToPostfix();
        String postfix = i2p.toPostFix(infix);
        String expectedPostfix="5413*9+746/*-";
        assertEquals(expectedPostfix,postfix);
        
    }
    @Test
    public void testParenthesizedAlphabeticExpression() {
        String infix="(A*(B+(C/D)))";
        InfixToPostfix i2p = new InfixToPostfix();
        String postfix = i2p.toPostFix(infix);
        String expectedPostfix="ABCD/+*";
        assertEquals(expectedPostfix,postfix);
        
    }
}
