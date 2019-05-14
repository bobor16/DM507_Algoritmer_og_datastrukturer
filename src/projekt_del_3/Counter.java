package projekt_del_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;


public class Counter {

    // java code that create ASCII frequency table from a text file
    public static final int ASCII = 256;

    public static void main(String[] args) {
        try {
            int[] frequency = createTable("C:\\Users\\rasmu\\OneDrive\\SDU\\4. Semester\\DM507 - Algoritmer og Datastrukturer\\Projects\\textFile.txt");


            if (frequency.length == 0)
                System.out.println("Error reading from file");
            else {
                for (int i = 32; i < ASCII; i++)
                    if (frequency[i] > 0) {
                        System.out.println("ASCII code: " + i + " ,character: " + (char) i
                                + " ,frequency: "
                                + frequency[i]);
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
        File f = new File(fileName);
        try (FileReader r = new FileReader(f)) {
            while (r.ready()) {
                int ch = r.read();
                if (ch >= 0 && ch < frequency.length)
                    frequency[ch]++;
                else
                    System.out.println("Not ASCII: " + ch + " " + (char) ch);
            }
        }
        return frequency;

    }
}
