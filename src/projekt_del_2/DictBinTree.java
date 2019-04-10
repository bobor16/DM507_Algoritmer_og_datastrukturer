package projekt_del_2;

/**
 * @author Borgar Bordoy - bobor16@student.sdu.dk
 * @author Martin Lykke - mlykk17@student.sdu.dk
 * @author Rasmus Hansen - raha817@student.sdu.dk
 */
public class DictBinTree implements Dict {

    private Tree tree;
    private Node node;
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
     * The initialized node 'y' is given the value null, and the node x is the
     * root of the tree. While the root is different from null, the integer 'k'
     * in inserts parameter is the root. If the key input less then the root, it
     * is placed as the left child, and if it is larger it is placed as the
     * right child.
     *
     * @param k
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

    @Override
    public int[] orderedTraversal() {
        this.sorted = new int[this.number];
        this.counter = 0;
        treeWalk(tree.getRoot());
        return sorted;
    }

    private void treeWalk(Node n) {
        if (n != null) {
            treeWalk(n.getLeftChild());
            this.sorted[this.counter++] = n.getKey();
            treeWalk(n.getRightChild());
        }
    }

    /*
     * Searches the tree to find a value
     * Returns x if k is equal to x key
     * Returns left child if k is smaller than key
     * Otherwise, rightchild is returned
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

    @Override
    public boolean search(int k) {
        Node x = tree.getRoot();
        Node z = treeSearch(x, k);
        return z != null;
    }
}

class Node {

    private int key;
    private Node left;
    private Node right;

    /**
     * sets up a node structure the key parameter is the value of the node
     */
    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public int getKey() {
        return key;
    }

    public Node getLeftChild() {
        return left;
    }

    public Node getRightChild() {
        return right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeftChild(Node left) {
        this.left = left;
    }

    public void setRightChild(Node right) {
        this.right = right;
    }
}

class Tree {

    private Node root;
    private int size;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
