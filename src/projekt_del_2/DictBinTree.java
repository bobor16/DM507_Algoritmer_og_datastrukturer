package projekt_del_2;

/**
 * @author Borgar Bordoy - bobor16@student.sdu.dk
 * @author Martin Lykke - mlykk17@student.sdu.dk
 * @author Rasmus Hansen - raha817@student.sdu.dk
 */
public class DictBinTree implements Dict {

    private Tree tree;
    private int[] sorted;
    private int number;
    private int counter;

    /**
     * Constructor for DictBinTree
     */
    public DictBinTree() {
        tree = new Tree();
    }

    /**
     * The initialized node 'y' is given the value null, and the node 'x' is the
     * root of the tree. While the root is different from null, the integer 'k'
     * in inserts parameter is the root. If the key input less then the root, it
     * is placed as the left child, and if it is larger it is placed as the
     * right child.
     *
     * @param k is the key value being inserted.
     */
    @Override
    public void insert(int k) {

        Node z = new Node(k);
        Node y = null;
        Node x = tree.getRoot();

        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        if (y == null) {
            tree.setRoot(z);
        } else if (z.getKey() < y.getKey()) {
            y.setLeftChild(z);
        } else {
            y.setRightChild(z);
        }
        this.number++;
    }

    /**
     * Creates a copy of the input from the insert method and sorts it by
     * calling the treeWalk() method.
     *
     * @return returns a Sorted array.
     */
    @Override
    public int[] orderedTraversal() {
        this.sorted = new int[this.number];
        this.counter = 0;
        treeWalk(tree.getRoot());
        return sorted;
    }

    /**
     * If the node n is different from null, the method recursively sorts the
     * value either to the left or right.
     *
     * @param n Node is the Node value, which is being placed into the array
     */
    private void treeWalk(Node n) {
        if (n != null) {
            treeWalk(n.getLeftChild());
            this.sorted[this.counter++] = n.getKey();
            treeWalk(n.getRightChild());
        }
    }

    /**
     * treeSearch searches the tree to find a value. Firstly it tests if the
     * root of the tree is null by the if statement x is null, if so it returns
     * the x value. In the same if statement treeSearch checks to see if Key k
     * being search for is the x.getKey() value, if so it returns the x value.
     * and the Search stops. But if x is not null or k is not x the treeSearch
     * goes to the next set of if and else statements. If k is less than
     * x.getLeftChild() then it returns a Recursive call to treeSearch with a
     * new x value and the same k value, If k greater than x.getLeftChild() is
     * not true it returns a Recursive call to treeSearch with x.getRightChild
     * and the same k value.
     *
     * @param x is the Root Node
     * @param k is the Key Value being search for.
     */
    public Node treeSearch(Node x, int k) {
        if (x == null || k == x.getKey()) {
            return x;
        }
        if (k < x.getKey()) {
            return treeSearch(x.getLeftChild(), k);
        } else {
            return treeSearch(x.getRightChild(), k);
        }
    }

    /**
     * The search method creates a copy of the root of the tree by setting Node
     * x = tree.getRoot() and places the Node x into a new Node with two
     * parameters, x to define the root atn k which is the search goal.
     *
     * @param k is the key value being search for.
     * @return returns true or false depending on what value x has.
     */
    @Override
    public boolean search(int k) {
        Node x = tree.getRoot();
        Node z = treeSearch(x, k);
        return z != null;
    }
}
