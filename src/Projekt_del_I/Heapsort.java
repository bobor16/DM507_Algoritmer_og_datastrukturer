/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekt_del_I;

import java.util.Scanner;

/**
 *
 * @author Borgar Bordoy
 */
public class Heapsort implements PQ {

    public static void main(String[] args) {
        PQ pq = (PQ) new PQHeap(1000);
        int n = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            pq.insert(new Element(sc.nextInt(), null));
            n++;
        }
        while (n > 0) {
            System.out.println(pq.extractMin().getKey());
            n--;
        }

    }

    @Override
    public Element extractMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Element e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
