package com.metacube.Search;

public class BinarySearchTree<T extends Comparable> {
    // Root of Binary Tree
    private TreeNode<T> root;
    
    public BinarySearchTree(TreeNode<T> root) {
        this.root = root;
    }
    
    public BinarySearchTree() {
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
    
    //this method adds node to binary search tree
    public TreeNode<T> addToTree(TreeNode<T> rootOfSubtree,Comparable<T> data, int index) {
        TreeNode<T> newNode = new TreeNode<T>(data,index);
        if(rootOfSubtree == null) {
            rootOfSubtree=newNode;
        } else {
            if(data.toString().compareTo(rootOfSubtree.getData().toString()) < 0 ) {
                rootOfSubtree.setLeft(addToTree(rootOfSubtree.getLeft(),data,index));
            } else {
                rootOfSubtree.setRight(addToTree(rootOfSubtree.getRight(), data,index));
            }
        }
        return rootOfSubtree;
    }
    
    public int search(Comparable<T> data, TreeNode<T> rootOfSubtree) {
        //if reached end of subtree but not found
        if(rootOfSubtree == null) {
            System.out.println("Element not found in the array ");
            return -1;
        } else if(rootOfSubtree.getData().compareTo((T) data) == 0) {        
            //if root is the element to search
            return rootOfSubtree.getIndex();
        } else if(rootOfSubtree.getData().compareTo((T) data) > 0) {
            //if root element > search value ;continue searching in left subtree
            return search(data,rootOfSubtree.getLeft());
        } else {
            //if root element < search value; continue searching in right subtree
            return search(data,rootOfSubtree.getRight()); 
        }
    }
    
    
}
