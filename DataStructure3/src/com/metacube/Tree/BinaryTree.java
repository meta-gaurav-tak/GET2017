package com.metacube.Tree;

class BinaryTree {
    // Root of Binary Tree
    TreeNode root;
    String treeTraversalString="";
    
    public BinaryTree(TreeNode root) {
        this.root = root;
    }
    
    public BinaryTree() {
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    private String postOrder(TreeNode root) { 
        if (root == null) {
            return "";
        } else {
        postOrder(root.getLeft());                     //PostOrder(left)
        postOrder(root.getRight());                    //PostOrder(right)
        this.treeTraversalString+=root.getData() + " ";     //get Root
        return this.treeTraversalString;
        }
    }
 
    /* print tree nodes in pre-order traversal*/
    private String preOrder(TreeNode root) {
        if (root == null) {
            return "";
        }else {
        this.treeTraversalString += root.getData() + " "; //getRoot
        preOrder(root.getLeft());                   //Preorder(left)
        preOrder(root.getRight());                  //Preorder(right)
        return this.treeTraversalString;
        }
    }
    
    public String traversePreOrder() throws TreeRootNotDefinedException {
        if(this.root==null){
            System.out.println("Empty tree");
            throw new TreeRootNotDefinedException();
        }
        this.treeTraversalString = "";
        return preOrder(this.root);
    }
    
    public String traversePostOrder() throws TreeRootNotDefinedException {
        if(this.root==null){
            System.out.println("Empty tree");
            throw new TreeRootNotDefinedException();
        }
        this.treeTraversalString = "";
        return postOrder(this.root);
    }
    //checks if two tree or subtrees are mirror image of each other
    boolean areMirror(TreeNode first, TreeNode second) {
        //if both tree traversed completely
        if (first == null && second == null) {
            return true;
        }
        // if only one tree has been completely traversed
        if (first == null || second == null) { 
            return false;
        }
        //if two nodes have same value compare left subtree of first with right subtree of second and vice versa
        return ( (first.getData().toString().equals(second.getData().toString()))
                && areMirror(first.left, second.right) && areMirror(first.right, second.left) );
    }
    
    //this method adds nodes to tree as in a binary search tree
    public TreeNode addToTree(TreeNode rootOfSubtree,Object data) {
        TreeNode newNode = new TreeNode(data);
        if(rootOfSubtree==null) {
            rootOfSubtree=newNode;
        } else {
            if(data.toString().compareTo(rootOfSubtree.getData().toString()) < 0 ) {
                rootOfSubtree.setLeft(addToTree(rootOfSubtree.getLeft(),data));
            } else {
                rootOfSubtree.setRight(addToTree(rootOfSubtree.getRight(), data));
            }
        }
        return rootOfSubtree;
    }
    
    /*public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root=tree.addToTree(tree.root, 1);
        tree.root=tree.addToTree(tree.root, 4);
        tree.root=tree.addToTree(tree.root, 2);
        tree.root=tree.addToTree(tree.root, 0);
        tree.root=tree.addToTree(tree.root, 19);
        System.out.println("Preorder traversal of binary tree is ");
        try {
            System.out.println(tree.traversePreOrder());
        } catch (TreeRootNotDefinedException e) {

            e.printStackTrace();
        }
 
        System.out.println("\nPostorder traversal of binary tree is ");
        try {
            System.out.println(tree.traversePostOrder());
        } catch (TreeRootNotDefinedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        tree1.root = new TreeNode(1);
        tree2.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(3);
        tree1.root.left.left = new TreeNode(4);
        tree1.root.left.right = new TreeNode(5);
 
        tree2.root.left = new TreeNode(3);
        tree2.root.right = new TreeNode(2);
        tree2.root.right.left = new TreeNode(5);
        tree2.root.right.right = new TreeNode(4);
 
        if (tree.areMirror(tree1.root, tree2.root) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }*/
    
}
