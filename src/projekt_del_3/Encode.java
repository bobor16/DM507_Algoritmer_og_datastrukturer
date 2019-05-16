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
 * @author Borgar Bordoy - bobor16@student.sdu.dk
 * @author Martin Lykke - mlykk17@student.sdu.dk
 * @author Rasmus Hansen - raha817@student.sdu.dk
 */

public class Encode {

    public static final int ASCII = 256;
    private static String[] codes = new String[ASCII];
    private static String fileInputPath;
    private static String fileOutputPath;
  /* 
     Starts out by creating encode object
     to call methods through the object.
     Creates an int array which is set equal
     to the results of createTable(input)
     which takes a file as inputt
    */
    public static void main(String[] args) throws Exception {
        fileInputPath = args[0];
        fileOutputPath = args[1];
        Encode encode = new Encode();
        int[] frequency = encode.createTable(fileInputPath);
        Element e = encode.huffman(frequency);
        encode.makeCode((Node) e.getData(), "");
        FileInputStream f = new FileInputStream(fileInputPath);
        FileOutputStream fo = new FileOutputStream(fileOutputPath);
        BitOutputStream b = new BitOutputStream(fo);

        for (int i : frequency) {
            b.writeInt(i);
        }
        // Writes frequencies of bits to output
        int i;
        while ((i = f.read()) != -1) {
            for (char c : codes[i].toCharArray()) {
                b.writeBit(Character.getNumericValue(c));
            }
        }

//        b.writeBit(0);
//        b.writeBit(1);
        f.close();
        b.close();
    }
    /*
     Takes a file the user inputs in parameter
     Throws exception if file is not found
     Throws IOException if for example trying
     to read data and stream suddenly gets closed
     Creates an int array of 256
     Reads all bytes in while loop from the
     input stream, and counts them in a
     frequency array, which is returned
    */
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
    /*
     Checks right and left nodes in tree
     and assigns the values 1 or 0
     depending on whether right or left 
     child is null
     If 
    */
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
     /*
    This method creates our huffman tree.
    It takes frequency array as parameter
    and runs the huffman algorithm,
    which takes ints from frequency
    and puts them in nodes
    */
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
