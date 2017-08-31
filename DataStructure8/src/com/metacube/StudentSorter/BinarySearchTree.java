package com.metacube.StudentSorter;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {
    // Root of Binary Tree
    private TreeNode root;
    private List<Integer> traverseList;
    
    public List<Integer> getTraverseList() {
        return traverseList;
    }

    public void setTraverseList(List<Integer> traverseList) {
        this.traverseList = traverseList;
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
        traverseList = new LinkedList<Integer>();
    }
    
    public BinarySearchTree() {
        traverseList = new LinkedList<Integer>();
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    //this method adds node to binary search tree
    public TreeNode addToTree(TreeNode rootOfSubtree,int data) {
        TreeNode newNode = new TreeNode(data);
        if(rootOfSubtree == null) {
            rootOfSubtree=newNode;
        } else {
            if(data < rootOfSubtree.getData() ) {
                rootOfSubtree.setLeft(addToTree(rootOfSubtree.getLeft(),data));
            } else {
                rootOfSubtree.setRight(addToTree(rootOfSubtree.getRight(), data));
            }
        }
        return rootOfSubtree;
    }
    
    public void traverseInorder(TreeNode rootOfSubtree) {
        if(rootOfSubtree == null) {
            return;
        }
        traverseInorder(rootOfSubtree.getLeft());
        traverseList.add(rootOfSubtree.getData());
        traverseInorder(rootOfSubtree.getRight());
    }
  
}
