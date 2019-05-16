package projekt_del_3;

import Projekt_del_I.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import projekt_del_2.Node;

/**
 * @author Borgar Bordoy - bobor16@student.sdu.dk
 * @author Martin Lykke - mlykk17@student.sdu.dk
 * @author Rasmus Hansen - raha817@student.sdu.dk
 */

public class Decode {

    private static String filePath;
    private static String newFilePath;
    private static final int ASCII = 256;
//    private final String[] codes = new String[ASCII];

    public static void main(String[] args) throws IOException {
        filePath = args[0];
        newFilePath = args[1];
        Encode e = new Encode();
        Decode d = new Decode();
        FileInputStream in = new FileInputStream(filePath);
        BitInputStream bin = new BitInputStream(in);
        d.decodeTree();
    }

    /**
     *
     *
     * @throws IOException
     */

    public void decodeTree() throws IOException {
        FileInputStream fin = new FileInputStream(filePath);
        FileOutputStream fout = new FileOutputStream(new File(newFilePath));
        BitInputStream bin = new BitInputStream(fin);
        BitOutputStream bout = new BitOutputStream(fout);
        int[] iArray = new int[ASCII];
        Encode e = new Encode();

        for (int i = 0; i < iArray.length; i++) {
            iArray[i] = bin.readInt();
        }

        Element element = e.huffman(iArray);

//        int j = bin.readInt();
//        bout.writeInt(j);
        int i;
        Node roots = (Node) element.getData();
        Node n = roots;

        /**
         * The while loop checks to see if the i value is not -1. If the loop is false,
         * then it means the file is empty. If the while loop is true, it goes trough the if statements.
         *
         * The first if statement checks if the i value is a 0, if true the decodeTree goes to the left node.
         * The second if statement checks if the i value is a 1, if true the decodeTree goes to the right node.
         * Only one of the first two if statements can ever be true, as the i value is either a 0 or a 1.
         *
         * The third and last if statement, checks if the node has an empty left and right child, if true,
         * decodeTree has has come to the end of a branch and writes the end result, and starts at the root again.
         */
        while ((i = bin.readBit()) != -1) {
            if (i == 0) {
                n = n.getLeftChild();
            }
            if (i == 1) {
                n = n.getRightChild();
            }
            if (n.getLeftChild() == null && n.getRightChild() == null) {
                bout.writeInt(n.getKey());
                n = roots;
            }
        }

//        bout.writeBit(0);
//        bout.writeBit(1);
    }
}
