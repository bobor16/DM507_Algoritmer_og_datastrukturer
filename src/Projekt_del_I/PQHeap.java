package Projekt_del_I;

import java.util.ArrayList;

/**
 *
 * @author Borgar Bordoy
 */
public class PQHeap implements PQ {

    private ArrayList<Element> list;

    public PQHeap(int maxElms) {
        this.list = new ArrayList<>(maxElms + 1);
        this.list.add(null);
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return (2 * i);
    }

    private int right(int i) {
        return (2 * i) + 1;
    }

    private void swap(int fpos, int spos) {
        Element temp = list.get(spos);
        list.set(spos, list.get(fpos));
        list.set(fpos, temp);
    }

    private void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int min;

        if (left <= list.size() - 1 && list.get(left).getKey() < list.get(i).getKey()) {
            min = left;
        } else {
            min = i;
        }
        if (right <= list.size() - 1 && list.get(right).getKey() < list.get(min).getKey()) {
            min = right;
        }
        if (min != i) {
            swap(min, i);
//            Element temp = list.get(i);
//            list.set(i, list.get(smallest));
//            list.set(smallest, temp);
            minHeapify(min);
        }
    }

    private Element min() {
        return list.get(1);
    }

    // Extracts first element in queue and moves the last element to be the first one
    // Lastly the heapify method is called which min-heapifies the ArrayList and min(minimum) is returned
    @Override
    public Element extractMin() {
        Element min = min();
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        minHeapify(1);
        return min;
    }


    // Inserts an element e into the priority-tree whilst also maintains the min-heap tree
    @Override
    public void insert(Element e) {
        list.add(e);
        int i = list.size() - 1;

        // The while loop maintains the heap by switching the element e with its parent,
        // making e the new parent, from there is compares the next parent to e and if e is smaller
        // than the new parent it will be switched again, until e has a parent that is smaller or e is at the root.
        while (i > 1 && list.get(parent(i)).getKey() > list.get(i).getKey()) {

//            swap(list.get(parent(i)).getKey(), i);
            Element temp = list.get(i);
            list.set(i, list.get(parent(i)));
            list.set(parent(i), temp);
            i = parent(i);
        }
    }

}
