package com.metacube.Search;

public class SearchFacade {
    /**
     * This method id designed to search an element in a provided array
     * @param elementToSearch is of Object type and contains the value to search
     * @param array holds reference to array on which search is to be performed
     * @return the index of the leftmost occurrence of the element in the array; -1 if no such element exists
     * @throws SearchElementTypeMismatchException
     */
    public int search(Object elementToSearch , Object[] array) throws SearchElementTypeMismatchException {
        if(elementToSearch == null || array == null) {
            throw new IllegalArgumentException("Any/All of the parameters is/are found null");
        } else {    
            /*
             * Checks if the element to search and the array elements are of same type
             * if yes only then continue else throw Custom Exception
             */
            if(array[0].getClass().equals(elementToSearch.getClass())){
                /*if array is of an object type that extends comparable
                 * Only then use the binary search logic
                 */
                if( array[0] instanceof Comparable ) {  
                    
                    BinarySearchTree<Comparable> tree = new BinarySearchTree<Comparable>(); 
                    for(int i=0; i < array.length; i++) {
                        tree.setRoot(tree.addToTree(tree.getRoot(), (Comparable<Comparable>)array[i],i));
                    }
                    System.out.println("Binary Search");
                    return tree.search((Comparable<Comparable>)elementToSearch, tree.getRoot());
                    
                } else {
                    /*
                     * Use linear search if the elements are not comparable to one another
                     */
                    for(int i=0;i<array.length;i++) {
                        if(array[i].equals(elementToSearch)) {
                            System.out.println("Linear Search");
                            return i;
                        }
                    }
                    return -1;
                }
            } else {
                throw new SearchElementTypeMismatchException();
            }
        }
    }
}