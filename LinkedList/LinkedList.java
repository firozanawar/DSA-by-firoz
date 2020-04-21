package LinkedList;

public class LinkedList {

    Node head;

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * insert At Beginning of list
     *
     * @param data
     */
    private void insertAtBeginning(int data) {

        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    /**
     * insert At End of list
     *
     * @param data
     */
    private void insertAtEnd(int data) {
        Node new_node = new Node(data);
        Node temp = head;

        while (temp != null && temp.next != null) {
            temp = temp.next;
        }

        temp.next = new_node;
    }

    private void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        tempNode.next = new_node;
        return;
    }

    private void insertAt(Node prev_node, int new_data) {

        if (prev_node == null) {
            System.out.println("Prev node seems to be empty");
            return;
        }

        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    private int getNodeCount(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + getNodeCount(node.next);
    }

    private int getCount(Node node) {
        return getNodeCount(node);
    }

    private void deleteNode(int key) {
        Node temp = head, prev = null;

        // # case 1 - delete the head
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // # case 2 - search node and delete
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // # case 3 -  when item is not present.
        if (temp == null) {
            return;
        }

        prev.next = temp.next; // Linking the previous to next node by delinking
    }

    private void deleteLinkedlList() {
        head = null;
    }

    private void reversByIterative(Node curr) {
        if (curr == null || curr.next == null)
            return;

        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        printListUsingHead(prev);
    }

    private Node reversByRecursive(Node curr) {
        Node node = reverse(curr);
        return node;
    }

    private Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHeadNode = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHeadNode;
    }

    private void printListUsingHead(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertAtBeginning(10);
        linkedList.insertAtBeginning(20);

        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);
        linkedList.append(50);

        linkedList.printList();

        //System.out.println();
        //linkedList.reversByIterative(linkedList.head);

        System.out.println();
        Node newHead = linkedList.reversByRecursive(linkedList.head);
        linkedList.printListUsingHead(newHead);
        System.out.println();
        System.out.println("Linkedlist count is: " + linkedList.getCount(newHead));
    }
}
