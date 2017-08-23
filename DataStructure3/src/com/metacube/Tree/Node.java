package com.metacube.Tree;

class TreeNode{
    private Object data;        //stores data for a tree node
    TreeNode left, right;       //pointer to left and right subtree of a node
    
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
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

    public TreeNode(Object data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
        
    }

    public TreeNode(Object data) {
        this.data = data;
        this.left=this.right=null;
    }
 
    
}
