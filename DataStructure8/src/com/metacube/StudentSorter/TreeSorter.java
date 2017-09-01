package com.metacube.StudentSorter;

import java.util.List;

import com.metacube.Exceptions.ArrayUndefinedException;
/**
 * Performs tree-sorting on an array 
 * Constructs a BST from array 
 * and returns an in-order traversal of the BST
 * @author Gaurav
 *
 */
public class TreeSorter {
    
    public static List<Integer> treeSort(Integer[] array) throws ArrayUndefinedException {
        if (array == null || array.length == 0) {
            throw new ArrayUndefinedException("Array is either empty or null");
        }
        BinarySearchTree tree = new BinarySearchTree();
        for(int i=0; i < array.length; i++) {
            tree.setRoot(tree.addToTree(tree.getRoot(),array[i]));
        }
        tree.traverseInorder(tree.getRoot());
        return tree.getTraverseList();
    }
}
