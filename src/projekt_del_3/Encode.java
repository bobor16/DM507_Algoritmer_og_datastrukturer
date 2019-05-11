/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_del_3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Borgar Bordoy
 */
public class Encode {

    private static int[] intArray = new int[257];

    public static void main(String[] args) throws Exception {
        String file = "C:/Users/borga/Desktop/textFile.txt";
        String file2 = "C:/Users/borga/Desktop/textFile2.txt";

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);

        BitInputStream bitInput = new BitInputStream(inputStream);
        BitOutputStream bitOutput = new BitOutputStream(outputStream);

        int i = bitInput.readInt();
        bitOutput.writeInt(i);

        int bit;
        while ((bit = bitInput.readBit()) != -1) {
            bitOutput.writeBit(bit);
        }
        bitInput.close();
        bitOutput.close();

    }

}
