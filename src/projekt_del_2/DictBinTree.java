/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_del_2;

/**
 *
 * @author Borgar Bordoy
 */
public class DictBinTree implements Dict {

    private Tree tree;
    private Node node;
    private int[] sorted;
    private int number;
    private int counter;

    public DictBinTree() {
        tree = new Tree();
    }

    @Override
    public void insert(int k) {
        Node z = new Node(k);
        Node y = null;
        Node x = tree.getRoot();

        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        if (y == null) {
            tree.setRoot(z);
        } else if (z.getKey() < y.getKey()) {
            y.setLeftChild(z);
        } else {
            y.setRightChild(z);
        }
        this.number++;
//        System.out.println("This is what has been inserted " + k);
    }

    @Override
    public int[] orderedTraversal() {
        this.sorted = new int[this.number];
        this.counter = 0;
        treeWalk(tree.getRoot());
        return sorted;
    }

    private void treeWalk(Node n) {
        if (n != null) {
            treeWalk(n.getLeftChild());
//            System.out.println(n.getKey());
            this.sorted[this.counter++] = n.getKey();
            treeWalk(n.getRightChild());
        }
    }

    @Override
    public boolean search(int k) {
        Node x = treeSearch(node, k);
//        System.out.println(" This is what the search() returns: " + x);
        return x != null;
    }

    private Node treeSearch(Node x, int k) {
//        if (x == null || k == x.getKey()) {
//            System.out.println(" This is what treeSearch() returns: " + x);
//            return x;
//        }
//        if (k < x.getKey()) {
//            System.out.println("(This is the left child) " + x.getLeftChild() + k);
//            return treeSearch(x.getLeftChild(), k);
//        } else {
//            System.out.println("(This is the right child) " + x.getRightChild() + k);
//            return treeSearch(x.getRightChild(), k);
//        }
        while (x != null && k != x.getKey()) {
            if (k < x.getKey()) {
//                x = x.getLeftChild();
                x.setLeftChild(x);
            } else {
//                x = x.getRightChild();
                x.setRightChild(x);
            }
        }
        System.out.println("(This is what the iterative treeSearch() returns) " + x);
        return x;
    }

}

class Node {

    private int key;
    private Node left;
    private Node right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public int getKey() {
        return key;
    }

    public Node getLeftChild() {
        return left;
    }

    public Node getRightChild() {
        return right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeftChild(Node left) {
        this.left = left;
    }

    public void setRightChild(Node right) {
        this.right = right;
    }
}

class Tree {

    private Node root;
    private int size;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
