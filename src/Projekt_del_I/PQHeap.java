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
        this.list = new ArrayList<>(maxElms + 1);
        this.list.add(null);

    }

    public int parent(int i) {
        return (i / 2);
    }

    public int left(int i) {
        return (i * 2);
    }

    public int right(int i) {
        return ((i * 2) + 1);
    }

    private Element minimum() {
        return list.get(1);
    }

    @Override
    public Element extractMin() {
        Element min = minimum();
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        minHeapify(1);
        return min;
    }

    @Override
    public void insert(Element e) {
        list.add(e);
        int i = list.size() - 1;

        while (i > 1 && list.get(parent(i)).getKey() > list.get(i).getKey()) {
            Element temp = list.get(i);
            list.set(i, list.get(parent(i)));
            list.set(parent(i), temp);
            i = parent(i);
        }
    }

    public void swapper(int i, int parent) {
        Element temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }

    public void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int min;

        if (l <= list.size() - 1 && list.get(l).getKey() < list.get(i).getKey()) {
            min = l;
        } else {
            min = i;
        }
        if (r <= list.size() - 1 && list.get(r).getKey() < list.get(i).getKey()) {
            min = r;
        }
        if (min != i) {
            swapper(i, min);
            minHeapify(min);
        }
    }
}
