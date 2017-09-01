package com.metacube.StudentSorter;


public class TreeNode{
    private int data;                    //stores data for a tree node

    private TreeNode left, right;       //pointer to left and right subtree of a node
    
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    //constructors
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
        
    }

    public TreeNode(int data) {
        this.data = data;
        this.left=this.right=null;
    }
 
}
