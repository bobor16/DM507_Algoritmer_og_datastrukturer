/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_del_2;

import java.util.HashMap;

/**
 *
 * @author Borgar Bordoy
 */
public class DictBinTree implements Dict {

    private int left;
    private int right;
    private HashMap map = new HashMap();
    private int key = 0;
    private int index = 0;

    public DictBinTree() {
        this.map = new HashMap();
        index++;
    }

    public int getLeft(int i) {
        return left;
    }

    public int getRight(int i) {
        return right;
    }

    @Override
    public void insert(int k) {
        Node x = null;
        Node y = null;

        while (x != null) {
            y = x;
            if (k < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
            k = y.getKey();
            if (y == null) {
                k = x.getKey();
            } else if (k < y.getKey()) {
                k = y.getLeft().getKey();
            } else {
                k = y.getRight().getKey();
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
            return search(node.getLeft().getKey());
        } else {
            return search(node.getRight().getKey());
        }
    }
}
