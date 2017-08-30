package com.metacube.Search;

public class SearchElementTypeMismatchException extends Exception {

    private static final long serialVersionUID = 1L;

    public SearchElementTypeMismatchException() {
        super("Search Element Type Different From Actual Array");
    }

}
