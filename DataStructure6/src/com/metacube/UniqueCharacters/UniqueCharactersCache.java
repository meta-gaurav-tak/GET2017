package com.metacube.UniqueCharacters;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharactersCache {
    private Map<String,Integer> uniqueCountmap;            // behaves as our cache store 
    
    public UniqueCharactersCache() {
        uniqueCountmap = new LinkedHashMap<String, Integer>(4,0.75f,true);
    }
    
    public int getNumberOfUniqueCharacters(String input) {
        
        if(input == null) {
            System.out.println("Supply only non null values : unique Characters cant exist ");
            return -1;
            
        } else {
            /*A cache hit*/
            if(uniqueCountmap.containsKey(input)){
                System.out.println("Retrieval from cache : ");
                return uniqueCountmap.get(input);
            } 
            
            /*if string has not occurred before
             * calculate number of unique characters in it 
             * put it into cache and return
             */
            else {
                UniqueCharactersOfString ucs = new UniqueCharactersOfString();
                ucs.getOnlyUniqueCharacters(input);
                System.out.println("Retrieval from method : ");
                uniqueCountmap.put(input,ucs.getUniqueCharacters().size());
            }
            return uniqueCountmap.get(input);
        }
    }
    
}
