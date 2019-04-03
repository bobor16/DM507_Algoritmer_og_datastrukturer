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

    public DictBinTree() {
    }

    public boolean isEmpty() {
        return (this.node == null);
    }

    @Override
    public void insert(int k) {

        Node y = null;
        Node x = new Node(k);

        while (x != null) {
            y = x;
            if (k < x.getKey()) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
            x.setParent(x);
            if (y == null) {
                k = x.getKey();
            } else if (k < y.getKey()) {
                k = y.getLeftChild().getKey();
            } else {
                k = y.getRightChild().getKey();
            }

        }
    }

    @Override
    public int[] orderedTraversal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean search(int k) {
        Node node = null;
        if (node.getKey() == k) {
            return true;
        }
        if (k < node.getKey()) {
            return search(node.getLeftChild().getKey());
        } else {
            return search(node.getRightChild().getKey());

        }
    }
}

class Node {

    private int key;
    private Node left;
    private Node right;
    private Node parent;

    public Node getParent() {
        return parent;
    }

    public Node(int key) {
        this.key = key;
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

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

}

class Tree {

    Node root;
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
