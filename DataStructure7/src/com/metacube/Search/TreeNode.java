package com.metacube.Search;


public class TreeNode<T>{
    private Comparable<T> data;            //stores data for a tree node
    private int index;                    //stores the index of the node in array 

    private TreeNode<T> left, right;       //pointer to left and right subtree of a node
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public Comparable<T> getData() {
        return data;
    }

    public void setData(Comparable<T> data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
    
    //constructors
    public TreeNode(Comparable<T> data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
        
    }

    public TreeNode(Comparable<T> data,int index) {
        this.data = data;
        this.index = index;
        this.left=this.right=null;
    }
 
}
