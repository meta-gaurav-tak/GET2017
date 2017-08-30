package com.metacube.Search;


public class Main {
    public static void main(String args[]) {
        SearchFacade facadeObject = new SearchFacade();
        Integer[] array = new Integer[] {8,5,7,9,0};
        try {
            System.out.println(facadeObject.search(9,array));
        } catch (SearchElementTypeMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
