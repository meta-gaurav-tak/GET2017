package com.metacube.Concordance;

public class Main {
    
    public static void main(String args[]) {
        String input = "";

        for (int index = 0; index < args.length; index++) {
            input += args[index];
        }

        System.out.println(input);
        
        Concordance concordance = new Concordance();
        System.out.println(concordance.getConcordanceString(input));
    }
}
