package Projekt_del_I;

import Projekt_del_I.Element;
import Projekt_del_I.PQ;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
//        Element temp = list.get(spos);
//        list.set(spos, list.get(fpos));
//        list.set(fpos, temp);
    }


    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest;

        if (left <= list.size() - 1 && list.get(left).getKey() < list.get(i).getKey()) {
            smallest = left;
        } else {
            smallest = i;
        }
        if (right <= list.size() - 1 && list.get(right).getKey() < list.get(smallest).getKey()) {
            smallest = right;
        }
        if (smallest != i) {
//            swap(smallest, i);
            Element temp = list.get(i);
            list.set(i, list.get(smallest));
            list.set(smallest, temp);
            heapify(smallest);
        }
    }

    private Element min() {
        return list.get(1);
    }

    @Override
    public Element extractMin() {
        Element min = min();
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        heapify(1);
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

            // swap(list.get(parent(i)).getKey(), i);
            Element temp = list.get(i);
            list.set(i, list.get(parent(i)));
            list.set(parent(i), temp);
            i = parent(i);
        }
    }

}
