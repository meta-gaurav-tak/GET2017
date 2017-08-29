package com.metacube.UniqueCharacters;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharactersOfString {
    private Set<Character> uniqueCharacters;        //set that contains the unique 
    
    public UniqueCharactersOfString() {
        this.uniqueCharacters = new HashSet<Character>();
    }

    public Set<Character> getUniqueCharacters() {
        return uniqueCharacters;
    }

    public void setUniqueCharacters(Set<Character> uniqueCharacters) {
        this.uniqueCharacters = uniqueCharacters;
    }

    public void getOnlyUniqueCharacters(String input) {
        this.uniqueCharacters = new HashSet<Character>();
        for(int index=0;index < input.length();index++) {
            uniqueCharacters.add(input.charAt(index));
        }
    }
    
}
