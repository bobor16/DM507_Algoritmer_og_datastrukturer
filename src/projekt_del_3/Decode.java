package projekt_del_3;

import Projekt_del_I.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import projekt_del_2.Node;

public class Decode {

    private static String file = "src/textFile2.txt";
    private static int ASCII = 256;
    private static String[] codes = new String[256];

    public static void main(String[] args) throws IOException {
        Encode e = new Encode();
        Decode d = new Decode();
        FileInputStream in = new FileInputStream(file);
        BitInputStream bin = new BitInputStream(in);
        int[] iArray = new int[ASCII];

        for (int i = 0; i < iArray.length - 1; i++) {
            iArray[i] = bin.readInt();
        }

        for (int i = 32; i < ASCII; i++) {
            if (iArray[i] > 0) {
                System.out.println("ASCII code: " + i + " character: " + (char) i
                        + " frequency: "
                        + iArray[i]);
            }
        }

        Element element = e.huffman(iArray);
        d.decodeTree((Node) element.getData());

//       
    }

    public void decodeTree(Node root) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        FileOutputStream fout = new FileOutputStream(new File("C:\\Users\\borga\\Documents\\NetBeansProjects\\DM507_Algoritmer_og_datastrukturer\\src\\textFile3.txt"));
        BitInputStream bin = new BitInputStream(fin);
        BitOutputStream bout = new BitOutputStream(fout);

        int j = bin.readInt();
        bout.writeInt(j);

        int i;
        Node n = root;
        while ((i = bin.readBit()) != -1) {
            if (i == 0) {
                n = n.getLeftChild();
            }
            if (i == 1) {
                n = n.getRightChild();
            }
            if (n.getLeftChild() == null && n.getRightChild() == null) {
                bout.writeInt(n.getKey());
                n = root;
            }
        }
        bout.writeBit(0);
        bout.writeBit(1);

        bin.close();
        bout.close();
    }
}
