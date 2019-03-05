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

    private int maxElms;
    private ArrayList<Element> list = new ArrayList<>();

    public PQHeap(int maxElms) {
        this.maxElms = maxElms;
    }

    public int getParent(Element i) {
        return (i.getKey() / 2);
    }

    public int getLeft(Element i) {
        return (i.getKey() * 2);
    }

    public int getRight(Element i) {
        return ((i.getKey() * 2) + 1);
    }

    @Override
    public Element extractMin() {

        for (int i = 0; i < list.size(); i--) {
            list.remove(i);
        }
        return 
    }

    @Override
    public void insert(Element e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
