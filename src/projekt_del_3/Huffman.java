/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_del_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Borgar Bordoy
 */
public class Huffman {

    static FileInputStream fin1 = null;

    public static void countChars(InputStream in) throws IOException {
        int count = 0;

        while (in.read() != -1) {
            count++;
        }

        System.out.println("Counted " + count + " chars.");
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("No file was given as an argument..!");
            System.exit(1);
        }
        String fileName = args[0];
        fin1 = new FileInputStream(fileName);
    }
}
