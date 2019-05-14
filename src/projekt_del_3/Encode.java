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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import projekt_del_2.Node;
//import static projekt_del_3.Counter.ASCII;

/**
 *
 * @author Borgar Bordoy
 */
public class Encode {

    public static int n;
    public static final int ASCII = 256;
//    private int[] nn = new int[255];
    private PQ queue = new PQHeap(255);
    private Node y;
    private Node x;

    public static void main(String[] args) throws Exception {
        try {
            int[] frequency = createTable("C:/Users/borga/Desktop/textFile.txt");

            if (frequency.length == 0) {
                System.out.println("Error reading from file");
            } else {
                for (int i = 32; i < ASCII; i++) {
                    if (frequency[i] > 0) {
                        System.out.println("ASCII code: " + i + " character: " + (char) i
                                + " frequency: "
                                + frequency[i]);
                    }
                }

                System.out.println("\nTotal characters in URL: " + sumTotal(frequency));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static int[] createTable(String fileName) throws FileNotFoundException, IOException {

        int[] frequency = new int[ASCII];
        int i = 0;
        int ch;

        FileInputStream fileInput = new FileInputStream(fileName);
        while ((i = fileInput.read()) != -1) {
            ch = (char) i;
            if (ch >= 0 && ch < frequency.length) {
                frequency[ch]++;
            }
        }
        return frequency;
    }

    private static int sumTotal(int[] array) {
        int total = 0;
        for (int x : array) {
            total += x;
        }
        return total;
    }

//    public Element huffman() {
//        String fileName = "C:/Users/borga/Desktop/textFile.txt";
//        String fileName2 = "C:/Users/borga/Desktop/textFile2.txt";
//        FileInputStream fis = new FileInputStream(fileName);
//        FileOutputStream fos = new FileOutputStream(fileName2);
//        BitInputStream bis = new BitInputStream(fis);
//        BitOutputStream bos = new BitOutputStream(fos);
//        int bint = bis.readInt();
//        int fint = fis.read();
//        for (int k = 0; fint < n.length; k++) {
//            nn[k] = fis.read();
//        }
//
//        for (int i = 0; i < n.length; i++) {
//            Node z = new Node(i);
//            x = (Node) queue.extractMin().getData();
//            y = (Node) queue.extractMin().getData();
//            z.setLeftChild(x);
//            z.setRightChild(y);
//            z.setFreq(x.getFreq() + y.getFreq());
//
//            queue.insert((Element) queue);
//            System.out.println(queue);
//        }
//
//        return queue.extractMin();
//    }
}
