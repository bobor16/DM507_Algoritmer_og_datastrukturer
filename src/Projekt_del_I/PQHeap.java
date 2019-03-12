/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekt_del_I;

import java.util.ArrayList;

/**
 *
 * @author Borgar Bordoy
 */
public class PQHeap implements PQ {

    private ArrayList<Element> list = new ArrayList<>();

    public PQHeap(int maxElms) {
        this.list = new ArrayList<>(maxElms);
    }

    public int getParent(int i) {
        return (i / 2);
    }

    public int getLeft(int i) {
        return (i * 2);
    }

    public int getRight(int i) {
        return ((i * 2) + 1);
    }

    private Element minimum() {
        return list.get(0);
    }

    @Override
    public Element extractMin() {
        Element min = minimum();

        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        list.trimToSize();
        minHeapify(0);

//        Element min = list.get(0);
//        Element lastItem = list.remove(list.size() - 1);
//        list.set(0, lastItem);
        minHeapify(0);

        return min;

    }

    @Override
    public void insert(Element e) {
        list.add(e);
        int i = list.size() - 1;

        while (i > 0 && list.get(getParent(i)).getKey() > list.get(i).getKey()) {
            Element temp = list.get(i);
            list.set(i, list.get(getParent(i)));
            list.set(getParent(i), temp);
            i = getParent(i);
        }
    }

    public void swapper(int i, int parent) {
        Element temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }

    public void minHeapify(int i) {
        int l = getLeft(i);
        int r = getRight(i);
        int min;
        if (l <= list.size() - 1 && list.get(l).getKey() < list.get(i).getKey()) {
            min = l;
        } else {
            min = i;
        }
        if (r <= list.size() && list.get(r).getKey() < list.get(i).getKey()) {
            min = r;
        } else {
            if (min != i) {

                swapper(i, min);
                minHeapify(min);

            }
        }

    }

}
