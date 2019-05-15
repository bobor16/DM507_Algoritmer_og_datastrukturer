package projekt_del_3;

import Projekt_del_I.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import projekt_del_2.Node;

public class Decode {
    private static String filePath;
    private static String newFilePath;
    private static final int ASCII = 256;
    private final String[] codes = new String[ASCII];

    public static void main(String[] args) throws IOException {
        filePath = args[0];
        newFilePath = args[1];
        Encode e = new Encode();
        Decode d = new Decode();
        FileInputStream in = new FileInputStream(args[0]);
        BitInputStream bin = new BitInputStream(in);
        int[] iArray = new int[ASCII];

        for (int i = 0;
                i < iArray.length - 1; i++) {
            iArray[i] = bin.readInt();
        }

        Element element = e.huffman(iArray);
        d.decodeTree((Node) element.getData());
    }

    public void decodeTree(Node root) throws IOException {
        FileInputStream fin = new FileInputStream(filePath);
        FileOutputStream fout = new FileOutputStream(new File(newFilePath));
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
