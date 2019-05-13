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
/**
 * The Node class holds vital information on how a Node and its children are
 * structured. Each Node has a Key which is the reference to itself, a left
 * child and a right child which also are Nodes. All Nodes are to call the
 * getKey() method to find its value, call the getLeftChild and getRightChild to
 * get their values. And lastly call the setLeftChild and setRightChild which
 * sets a Nodes child to the new value.
 */
public class Node {

    private int key;
    private Node left;
    private Node right;
    private int freq;

    /**
     * sets up a node structure the key parameter is the value of the node
     */
    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.freq = freq;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
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

    public void setLeftChild(Node left) {
        this.left = left;
    }

    public void setRightChild(Node right) {
        this.right = right;
    }
}
