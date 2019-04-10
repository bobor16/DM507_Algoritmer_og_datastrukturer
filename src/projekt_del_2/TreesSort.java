
package projekt_del_2;

import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * This class uses DictBinTree methods to
 * sort a list of integers that come from input
 */

public class TreesSort {

    public static void main(String[] args) {
        
        List<Integer> inputNumbers = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        
        while (scan.hasNextInt())
            
            inputNumbers.add(scan.nextInt());
        Dict dict = new DictBinTree();
        
        for (int numb : inputNumbers)
            dict.insert(numb);
        
        for (int numb : dict.orderedTraversal())
            System.out.println(numb);
        
    }
    
    }

