package com.metacube.Stack;
/**
 * this class is designed to convert an infix expression to post fix
 * @author Gaurav Tak
 *
 */
public class InfixToPostfix {
    private StackImplementation stack;   //internal stack to be used for conversions
    
    public InfixToPostfix() {
        this.stack = new StackImplementation();
        this.stack.setTop(null);
    }
    public String toPostFix(String infix) {
        if (infix == null || infix == "") {
            throw new IllegalArgumentException();
        }
        String postFix = "";
        char currentSymbol;
        for(int index = 0;index < infix.length();index++) {
    
            currentSymbol = infix.charAt(index);
            if(Character.isDigit(currentSymbol) || Character.isAlphabetic(currentSymbol)) { // if operand add to string
                postFix = postFix + currentSymbol;
            } else if(currentSymbol == '('){                          //if opening parenthesis push to stack
                this.stack.push(currentSymbol);
            } else if(currentSymbol == ')'){
                while(this.stack.peep() != (Character)'(' && !this.stack.isEmpty()){ // find a opening parenthesis for closing parenthesis  
                    postFix = postFix + this.stack.pop();
                }
                if(this.stack.peep() == (Character)'(') {
                    this.stack.pop();}        // removes opening parenthesis
            } else {
                while( !this.stack.isEmpty() && this.stack.peep() != (Character)'(' 
                        && precedence((Character)currentSymbol) <= precedence((Character)this.stack.peep()) ) { 
                    //pop and add to string until a higher precendence symbol exists at top
                    postFix = postFix+stack.pop();
                }
                this.stack.push(currentSymbol);
            }
        }
        while(!this.stack.isEmpty()){
            postFix = postFix + this.stack.pop();
        }
        if(postFix.charAt(postFix.length()-1) != '(' ) {
            return postFix;
        }
        else{
           return postFix.substring(0, postFix.length()-1); 
        }
    }
    
    //gives the precedence for a operator
    public int precedence(Character operator) {
        if(operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/' || operator == '%') {
            return 2;
        }
        return 0;
    }
    
    /*public static void main(String args[]) {
        String infix="54+46+45+46+465+45-44*55/5+89";
        InfixToPostfix i2p = new InfixToPostfix(); 
        System.out.println(i2p.toPostFix(infix));
    }*/
}
