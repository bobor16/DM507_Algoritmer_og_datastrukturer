package projekt_del_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

public class Counter {

    // java code that create ASCII frequency table from a text file
    public static final int ASCII = 256;

    public static void main(String[] args) {
        try {
            int[] frequency = createTable("C:/Users/borga/Desktop/textFile.txt");

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

                System.out.println("\nTotal characters in URL: " + sumTotal(frequency));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static int sumTotal(int[] array) {
        int total = 0;
        for (int x : array) {
            total += x;
        }
        return total;
    }

    public static int[] createTable(String fileName) throws FileNotFoundException, IOException {

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
}
