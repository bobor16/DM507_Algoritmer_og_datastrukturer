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
import java.io.IOException;
import projekt_del_2.DictBinTree;
import projekt_del_2.Node;

/**
 *
 * @author Borgar Bordoy
 */
public class Encode {

    public static final int ASCII = 256;
//    private PQ queue;

    public static void main(String[] args) throws Exception {
        Encode encode = new Encode();
        int[] frequency = encode.createTable("src/textFile.txt");

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

            System.out.println("\nTotal characters in URL: " + encode.sum(frequency));

            encode.huffman(frequency);
        }
    }

    public int[] createTable(String fileName) throws FileNotFoundException, IOException {

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

    private int sum(int[] i) {
        int total = 0;
        for (int x : i) {
            total += x;
        }
        return total;
    }

    public String[] makeCode() {
        String code = "";
        DictBinTree d = new DictBinTree();

        if (d.treeSearch(x, ASCII)) {

        }
    }

    public Element huffman(int[] C) {

        PQ Q = new PQHeap(C.length);
        for (int o = 0; o < C.length - 1; o++) {
            Node s = new Node(o);
            s.setFreq(C[o]);
            Q.insert(new Element(s.getFreq(), s));
        }

        for (int i = 1; i < C.length - 1; i++) {
            Node x;
            Node y;
            Node z = new Node(i);
            x = (Node) Q.extractMin().getData();
            y = (Node) Q.extractMin().getData();
            z.setLeftChild(x);
            z.setRightChild(y);
            z.setFreq(x.getFreq() + y.getFreq());
            Q.insert(new Element(z.getFreq(), z));
        }
        return Q.extractMin();

    }

}
