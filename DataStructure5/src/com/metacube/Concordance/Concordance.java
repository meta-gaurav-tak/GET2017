package com.metacube.Concordance;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Concordance {
    //method to generate a concordance map  for individual character of a string 
    public Map<Character,ArrayList<Integer>> getConcordanceMap(String input) {
        
        //the following map contains the concordance output
        Map<Character, ArrayList<Integer>> concordance = new TreeMap<Character, ArrayList<Integer>>();
        ArrayList<Integer> position;

        for (int count = 0; count < input.length(); count++) {
            if (concordance.containsKey(input.charAt(count))) {
                position = concordance.get(input.charAt(count));
                position.add(count);
                concordance.put(input.charAt(count), position);
            } else {
                position = new ArrayList<Integer>();
                position.add(count);
                concordance.put(input.charAt(count), position);
            }    
        }
        return concordance;    
    }
    
    //to generate output string of concordance from an input
    public String getConcordanceString(String input) {
        String output = "";
        for (char value : getConcordanceMap(input).keySet()) {
            output +=(value + " : " + getConcordanceMap(input).get(value)+"\t\t");
        }
        return output;
    }
}
