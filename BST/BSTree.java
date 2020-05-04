package BST;

class BSTNode {
    BSTNode left, right;
    int data;

    public BSTNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class BST {
    BSTNode root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private BSTNode insert(BSTNode node, int data) {
        if (node == null) {
            node = new BSTNode(data);
        } else {
            if (data <= node.getData()) {
                node.left = insert(node.getLeft(), data);
            } else {
                node.right = insert(node.getRight(), data);
            }
        }

        return node;
    }

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(BSTNode r, int value) {
        boolean found = false;

        while (r != null && !found) {
            int rval = r.getData();
            if (value < rval) {
                r = r.getLeft();
            } else if (value > rval) {
                r = r.getRight();
            } else {
                found = true;
                break;
            }

            found = search(r, value);
        }

        return found;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private BSTNode delete(BSTNode r, int data) {
        if (r == null) return r;

        if (data < r.getData()) {
            r.left = delete(r.getLeft(), data);
        } else if (data > r.getData()) {
            r.right = delete(r.getRight(), data);
        } else {
            if (r.left == null) {
                return r.right;
            } else if (r.right == null) {
                return r.left;
            }
            r.data = inOrderSuccessor(r.getRight());
            r.right = delete(r.getRight(), r.data);
        }

        return r;
    }

    public int inOrderSuccessor(BSTNode r) {
        int rval = r.getData();
        while (r.getLeft() != null) {
            rval = r.getData();
            r = r.getLeft();
        }

        return rval;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void preOrder(BSTNode r) {
        if (r != null) {
            System.out.println(r.getData() + " ");
            inOrder(r.getLeft());
            inOrder(r.getRight());
        }
    }

    public void inOrder(BSTNode r) {
        if (r != null) {
            inOrder(r.getLeft());
            System.out.println(r.getData() + " ");
            inOrder(r.getRight());
        }
    }

    public void postOrder(BSTNode r) {
        if (r != null) {
            inOrder(r.getLeft());
            inOrder(r.getRight());
            System.out.println(r.getData() + " ");
        }
    }
}

public class BSTree {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(4);
        bst.insert(5);
        bst.insert(43);

        System.out.println("Search: " + bst.search(4));
        //System.out.println("Search: " + bst.delete(4));
        bst.inOrder(bst.root);
    }
}
