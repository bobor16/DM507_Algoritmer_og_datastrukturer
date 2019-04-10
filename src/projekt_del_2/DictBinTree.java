package projekt_del_2;

/**
 *
 * @author Borgar Bordoy
 */
public class DictBinTree implements Dict {

    private Tree tree;
    private Node node;
    private int[] sorted;
    private int number;
    private int counter;

    public DictBinTree() {
        tree = new Tree();
    }

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

/* The Node class holds vital information on how a Node and its children are structured.
* Each Node has a Key which is the reference to itself, a left child and a right child which also are Nodes.
* All Nodes are to call the getKey() method to find its value, call the getLeftChild and getRightChild to get their values.
* And lastly call the setLeftChild and setRightChild which sets a Nodes child to the new value.
* */
class Node {
    
    private int key;
    private Node left;
    private Node right;

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

    public void setLeftChild(Node left) {
        this.left = left;
    }

    public void setRightChild(Node right) {
        this.right = right;
    }
}

// The Tree class hold the information of the root of the Tree, the Root of the Tree is a Node.
class Tree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


}
