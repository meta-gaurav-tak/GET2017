package com.metacube.Tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
    private BinaryTree tree;
    @Before
    public void populateTree() {
        tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.getRoot().setLeft(new TreeNode(2));
        tree.getRoot().setRight(new TreeNode(3));
        tree.getRoot().getLeft().setLeft(new TreeNode(4));
        tree.getRoot().getRight().setLeft(new TreeNode(5));
 
    }
    @Test
    public void testPreOrderPositive() {
       String treeTraversal="";
        try {
            treeTraversal = tree.traversePreOrder();
        } catch (TreeRootNotDefinedException e) {
            e.printStackTrace();
        }
       String expectedTraversal="1 2 4 3 5 ";
       assertEquals(treeTraversal,expectedTraversal);
    }
    @Test
    public void testPreOrderNegative() {
       String treeTraversal = "";
        try {
            treeTraversal = tree.traversePreOrder();
        } catch (TreeRootNotDefinedException e) {
            
            e.printStackTrace();
        }
       String expectedTraversal="1 2 3 4 5 ";
       assertNotEquals(treeTraversal,expectedTraversal);
    }
    @Test
    public void testPostOrderPositive() {
       String treeTraversal = "";
        try {
            treeTraversal = tree.traversePostOrder();
        } catch (TreeRootNotDefinedException e) {
            e.printStackTrace();
        }
       String expectedTraversal="4 2 5 3 1 ";
       assertEquals(treeTraversal,expectedTraversal);
    }
    @Test
    public void testPostOrderNegative() {
       String treeTraversal = "";
        try {
            treeTraversal = tree.traversePostOrder();
        } catch (TreeRootNotDefinedException e) {
            e.printStackTrace();
        }
       String expectedTraversal="1 2 4 3 5 ";
       assertNotEquals(treeTraversal,expectedTraversal);
    }
    
    @Test(expected=TreeRootNotDefinedException.class)
    public void testPreOrderException() throws TreeRootNotDefinedException {
        BinaryTree treeExceptionObject = new BinaryTree();
        treeExceptionObject.traversePreOrder();
    }
    
    @Test(expected=TreeRootNotDefinedException.class)
    public void testPostOrderException() throws TreeRootNotDefinedException {
        BinaryTree treeExceptionObject = new BinaryTree();
        treeExceptionObject.traversePostOrder();
    }
    
    
    @Test
    public void testMirrorTreePositive() {
        BinaryTree expectedMirrorTree = new BinaryTree();
        expectedMirrorTree.root = new TreeNode(1);
        expectedMirrorTree.getRoot().setLeft(new TreeNode(3));
        expectedMirrorTree.getRoot().setRight(new TreeNode(2));
        expectedMirrorTree.getRoot().getLeft().setRight(new TreeNode(5));
        expectedMirrorTree.getRoot().getRight().setRight(new TreeNode(4));
        assertTrue(tree.areMirror(tree.getRoot(), expectedMirrorTree.getRoot()));
    }
    @Test
    public void testMirrorTreeNegative() {
        BinaryTree expectedMirrorTree = new BinaryTree();
        expectedMirrorTree.root = new TreeNode(1);
        expectedMirrorTree.getRoot().setLeft(new TreeNode(3));
        expectedMirrorTree.getRoot().setRight(new TreeNode(2));
        assertFalse(tree.areMirror(tree.getRoot(), expectedMirrorTree.getRoot()));
    }
}
