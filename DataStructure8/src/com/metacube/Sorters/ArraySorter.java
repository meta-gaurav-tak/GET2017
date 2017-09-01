package com.metacube.Sorters;

import com.metacube.Exceptions.ArrayUndefinedException;

/**
 * The Interface ArraySorter.
 */
public interface ArraySorter {
    
    /**
     * Sort the input array
     *
     * @param arrayToSort the array to sort
     * @return the int[] sorted array
     * @throws ArrayUndefinedException the custom array undefined exception
     */
    public int[] sort(int[] arrayToSort) throws ArrayUndefinedException;
}
