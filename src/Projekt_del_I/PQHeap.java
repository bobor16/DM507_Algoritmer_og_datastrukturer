package Projekt_del_I;

//Imports ArrayLsit from java.util
import java.util.ArrayList;

/**
 *
 * @author Borgar Bordoy - bobor16@student.sdu.dk
 * @author Martin Lykke - mlykk17@student.sdu.dk
 * @author Rasmus Hansen - raha817@student.sdu.dk
 */
public class PQHeap implements PQ {

    //Instanciates ArrayList of type Element and names it list.
    private ArrayList<Element> list;

    //Constructor
    public PQHeap(int maxElms) {
        //Sets ArrayList to list and defines size.
        this.list = new ArrayList<>(maxElms + 1);

        //Adds null to the first index of the list.
        this.list.add(null);
    }

    // Calculates the index of the parent.
    private int parent(int i) {
        return (i / 2);
    }

    // Calculates the index of the parents left child.
    private int left(int i) {
        return (2 * i);
    }

    // Calculates the index of the parents right child.
    private int right(int i) {
        return (2 * i) + 1;
    }

    /**
     * Minimum heapifies the ArrayList. Finds the smallest key of a parent and
     * the children's keys. If the smallest is not the parent key, the smallest
     * child is exchanged with its parent.
     */
    private void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int min;

        /* The if statement checks if the left child is smaller than its parent,
        * and assigns the smaller of the two to "min".
         */
        if (left <= list.size() - 1 && list.get(left).getKey() < list.get(i).getKey()) {
            min = left;
        } else {
            min = i;
        }
        /**
         * The if statement checks if the right child is smaller than its
         * parent, if true it will be assigned to "min". To clarify the right
         * child compares itself with the parent which can be the former left
         * child or the parent "i", depending on what the above if statement has
         * done.
         */
        if (right <= list.size() - 1 && list.get(right).getKey() < list.get(min).getKey()) {
            min = right;
        }
        /**
         * This if statement swaps the parent with the smallest child. If the
         * new parent is not the smallest, it makes a recursive call.
         */
        if (min != i) {
            Element temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
            minHeapify(min);
        }
    }

    //Returns the Element on the 1'st index of the list.
    private Element min() {
        return list.get(1);
    }

    /**
     * Extracts first element in queue and moves the last element to be the
     * first one. Lastly the heapify method is called which min-heapifies the
     * ArrayList and min(minimum) is returned.
     */
    @Override
    public Element extractMin() {
        Element min = min();
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        minHeapify(1);
        return min;
    }

    /**
     * Inserts an element e into the priority-tree whilst also maintains the
     * min-heap tree.
     */
    @Override
    public void insert(Element e) {
        list.add(e);
        int i = list.size() - 1;
        /**
         * The while loop maintains the heap by switching the element e with its
         * parent, making e the new parent, from there is compares the next
         * parent to e and if e is smaller than the new parent it will be
         * switched again, until e has a parent that is smaller or e is at the
         * root.
         */

        while (i > 1 && list.get(parent(i)).getKey() > list.get(i).getKey()) {
            Element temp = list.get(i);
            list.set(i, list.get(parent(i)));
            list.set(parent(i), temp);
            i = parent(i);
        }
    }
}
