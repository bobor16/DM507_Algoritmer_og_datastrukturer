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

    private int size = 0;
    private int[] data;
    private int left;
    private int right;

    public DictBinTree() {
        this.data = new int[size];

    }

    public int getLeft(int l) {
        return left;
    }

    public int getRight(int r) {
        return right;
    }

    public int treeMin(int x) {
        
    }

    @Override
    public void insert(int k) {

    }

    @Override
    public int[] orderedTraversal() {
    }

    @Override
    public boolean search(int k) {
        int low = 0;
        int high = size - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (data[middle] == k) {
                return true;
            }
            if (data[middle] < k) {
                low = middle + 1;
            }
            if (data[middle] > k) {
                high = middle - 1;
            }
        }
        return false;

    }

}
