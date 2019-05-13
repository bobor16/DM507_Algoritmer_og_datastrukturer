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
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Borgar Bordoy
 */
public class Encode {

    private static List<Integer> list = new ArrayList<>();
    private static List<Integer> freq = new ArrayList<>();
    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static int s = (list.size() / 2);
    private static PQ P = new PQHeap(s);
    public static int n;

    public static void main(String[] args) throws Exception {

        //String file = "C:/Users/borga/Desktop/textFile.txt";
        //String file2 = "C:/Users/borga/Desktop/textFile2.txt";
        String file = "C:\\Users\\rasmu\\OneDrive\\SDU\\4. Semester\\DM507 - Algoritmer og Datastrukturer\\Projects\\textFile.txt";
        String file2 = "C:\\Users\\rasmu\\OneDrive\\SDU\\4. Semester\\DM507 - Algoritmer og Datastrukturer\\Projects\\textFile2.txt";


        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);

        BitInputStream bitInput = new BitInputStream(inputStream);
        BitOutputStream bitOutput = new BitOutputStream(outputStream);

        int i = bitInput.readInt();
        System.out.println(i);
        bitOutput.writeInt(i);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            P.insert(new Element(iterator.next(), iterator.next()));
        }
        extract();

        int bit;

        while ((bit = bitInput.readBit()) != -1) {
            System.out.println(bit);
            if (map.get(bit) != null) {
                map.put(bit, map.get(bit) + 1);
            } else {
                map.put(bit, 1);
            }
            bitOutput.writeBit(bit);
        }
        bitInput.close();
        bitOutput.close();

        for (Entry<Integer, Integer> e : map.entrySet()) {
            list.add(e.getValue());
            list.add(e.getKey());
        }
        System.out.println(map);
        System.out.println(list);

        bitOutput.writeBit(0);
        bitOutput.writeBit(1);
    }
    
    public static void huffmanMethod() {
        
       // n = |C| 
      //  * Q = C 
        
        for (int i = 0; i < n-1; i++) {
            Element[] elementZ = new Element[2];
            elementZ[0] = P.extractMin();
            elementZ[1] = P.extractMin();
            int freg = elementZ[0].getKey() + elementZ[1].getKey();
            
           // P.insert(new Element()); Need parameter for the element
    }
      //  P.extractMin() This needs to return the root of the tree
    }
    
    public static void extract() {
        Element e;
        Element el;

        for (int i = 0; i <= (s - 1); i++) {
            e = P.extractMin();
            el = P.extractMin();

            Element element = new Element(e.getKey() + el.getKey(), null);
            P.insert(element);
        }
    }

}


// Huffman(C) peseudocode på side 431
/**
 * n = |C|
 * Q = C
 * for i = 1 to n -1
 *      allocate a new node z
 *      z.left = x = EXTRACT-Min(Q)
 *      z.right = y = EXTRACT-Min(Q)
 *      z.freg = x.freq + y.freg
 *      INSERT(Q, z)
 * return EXTRACT-Min(Q)    // return the root of the tree
 **/
