package projekt_del_3;

import Projekt_del_I.Element;
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

        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(file);
//
        BitInputStream bin = new BitInputStream(in);
        BitOutputStream bout = new BitOutputStream(out);

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
        e.makeCode((Node) element.getData(), "");

        int j = bin.readInt();

        int bit;
        while ((bit = bin.readBit()) != -1) {
            bout.writeBit(bit);

        }

        in.close();
        bin.close();
    }
}
