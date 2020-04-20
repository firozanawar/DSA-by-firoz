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

    private void insertAtBeginning(int data) {

        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    private void insertAtEnd(int data) {
        Node new_node = new Node(data);
        Node temp = head;

        while (temp != null && temp.next != null) {
            temp = temp.next;
        }

        temp.next = new_node;
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

    private static int getCount() {
        // TODO: 21/04/20
        return 0;
    }

    private void deleteNode(int key) {

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

        linkedList.printList();
    }
}
