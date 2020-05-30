package LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);

        head = list.reverseIterative(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

    static Node head;

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /**
     * Initialize three pointers prev as NULL, curr as head and next as NULL.
     * Iterate trough the linked list. In loop, do following.
     * // Before changing next of current,
     * // store next node
     * next = curr->next
     * // Now change next of current
     * // This is where actual reversing happens
     * curr->next = prev
     *
     * // Move prev and curr one step forward
     * prev = curr
     * curr = next
     */
    Node reverseIterative(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
}
