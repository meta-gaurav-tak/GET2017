package com.metacube.UniqueCharacters;

public class Main {
    public static void main (String args[]) {
        UniqueCharactersCache ucs = new UniqueCharactersCache();
        System.out.println(ucs.getNumberOfUniqueCharacters("meerajmeeraj"));
        System.out.println(ucs.getNumberOfUniqueCharacters("meerajmeeraj"));
        System.out.println(ucs.getNumberOfUniqueCharacters("ABCABCjklijkhdjhdjh"));
        System.out.println(ucs.getNumberOfUniqueCharacters(null));
        
    }
}
