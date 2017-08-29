/**
 * 
 */
package com.metacube.Employee;

import java.util.Comparator;

/**
 * A comparator class used to compare between to employees
 * on basis of their Name
 * @author Gaurav Tak
 *
 */
public class NameComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        Employee e1 = (Employee) o1;
        Employee e2 = (Employee) o2;
        return e1.getName().compareTo(e2.getName());
    }

}
