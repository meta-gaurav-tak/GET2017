package com.metacube.StudentSorter;

import java.util.List;

public class TreeSorter {
    
    public static List<Integer> treeSort(Integer[] array) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i=0; i < array.length; i++) {
            tree.setRoot(tree.addToTree(tree.getRoot(),array[i]));
        }
        tree.traverseInorder(tree.getRoot());
        return tree.getTraverseList();
    }
}
