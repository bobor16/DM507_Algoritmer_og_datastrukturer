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

    public DictBinTree() {
        this.map = new HashMap();
    }

    public int getLeft(int i) {
        return left;
    }

    public int getRight(int i) {
        return right;
    }

    public int minimum(int x) {
        while (!map.containsKey(null)) {
            x = (int) map.get(getLeft(x));
        }
        return x;
    }

    public int maximum(int x) {
        while (!map.containsKey(null)) {
            x = (int) map.get(getRight(x));
        }
        return x;
    }

    @Override
    public void insert(int k) {

    }

    @Override
    public int[] orderedTraversal() {
    }

    @Override
    public boolean search(int k) {
//        int low = 0;
//        int high = size - 1;
//
//        while (high >= low) {
//            int middle = (low + high) / 2;
//            if (data[middle] == k) {
//                return true;
//            }
//            if (data[middle] < k) {
//                low = middle + 1;
//            }
//            if (data[middle] > k) {
//                high = middle - 1;
//            }
//        }
//        return false;

    }

}
