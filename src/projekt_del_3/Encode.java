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
import projekt_del_2.Node;

/**
 *
 * @author Borgar Bordoy
 */
public class Encode {

    public static final int ASCII = 256;
    private static String[] codes = new String[ASCII];
    private static String input = "src/textFile.txt";
    private static String output = "src/textFile2.txt";

    public static void main(String[] args) throws Exception {
        Encode encode = new Encode();
        int[] frequency = encode.createTable(input);

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

            Element e = encode.huffman(frequency);
            encode.makeCode((Node) e.getData(), "");

            FileInputStream f = new FileInputStream(input);
            FileOutputStream fo = new FileOutputStream(output);
            BitOutputStream b = new BitOutputStream(fo);

            for (int i : frequency) {
                b.writeInt(i);
            }

            int i;
            while ((i = f.read()) != -1) {
                for (char c : codes[i].toCharArray()) {
                    b.writeBit(Character.getNumericValue(c));
                }
            }

            b.writeBit(0);
            b.writeBit(1);

            f.close();
            b.close();
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
        fileInput.close();

        return frequency;
    }

    private int sum(int[] i) {
        int total = 0;

        for (int x : i) {
            total += x;
        }
        return total;
    }

    public String[] makeCode(Node root, String s) {
        String code = s;

        if (root.getRightChild() != null) {
            makeCode(root.getRightChild(), code + "1");
        }
        if (root.getLeftChild() != null) {
            makeCode(root.getLeftChild(), code + "0");
        } else {
            this.codes[root.getKey()] = code;
        }
        return null;
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
