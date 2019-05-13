/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_del_3;

import Projekt_del_I.Element;
import Projekt_del_I.PQ;
import Projekt_del_I.PQHeap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import projekt_del_2.Node;

/**
 *
 * @author Borgar Bordoy
 */
public class Huffman {

    private int[] n = new int[255];
    private PQ queue = new PQHeap(255);
    private Node y;
    private Node x;

    public Element encode() throws Exception {
        String fileName = "C:/Users/borga/Desktop/textFile.txt";
        String fileName2 = "C:/Users/borga/Desktop/textFile2.txt";
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileName2);

//        BitInputStream bis = new BitInputStream(fis);
//        BitOutputStream bos = new BitOutputStream(fos);

//        int bint = bis.readInt();
        int fint = fis.read();

        for (int k = 0; fint < n.length; k++) {
            n[k] = fis.read();
        }

        for (int i = 0; i < n.length; i++) {
            Node z = new Node(i);
            x = (Node) queue.extractMin().getData();
            y = (Node) queue.extractMin().getData();
            z.setLeftChild(x);
            z.setRightChild(y);
            z.setFreq(x.getFreq() + y.getFreq());

            queue.insert((Element) queue);
            System.out.println(queue);
        }

        return queue.extractMin();
    }

    public static void main(String[] args) throws Exception {
        Huffman h = new Huffman();
        h.encode();
    }
}
