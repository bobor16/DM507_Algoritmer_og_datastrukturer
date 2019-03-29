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
    private Node root;
    private int key = 0;

    public DictBinTree() {
        this.map = new HashMap();
        root = new Node(key);
    }

    public int getLeft(int i) {
        return left;
    }

    public int getRight(int i) {
        return right;
    }

    // Everything to the left, to the left everything is in a box to the left.. traaalalala - ft Beyonce
    public int minimum(int x) {
        while (!map.containsKey(null)) {
            x = (int) map.get(getLeft(x));
        }
        return x;
    }

    // Everything to the right
    public int maximum(int x) {
        while (!map.containsKey(null)) {
            x = (int) map.get(getRight(x));
        }
        return x;
    }

    @Override
    public void insert(int k) {
        int root = 0;
        while (!map.containsKey(null)) {
            if (k <= minimum(k)) {
                map.put(k, null);
            } else {

            }
        }
    }

    @Override
    public int[] orderedTraversal() {
    }

    @Override
    public boolean search(int k) {
        if (map.containsKey(k)) {
            return true;
        }
        return false;
    }
}
