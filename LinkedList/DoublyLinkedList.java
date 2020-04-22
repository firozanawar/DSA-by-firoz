package LinkedList;

class Node {
    public int data;
    public Node next;
    public Node prev;

    public void displayNodeData() {
        System.out.println("{ " + data + " } ");
    }
}

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    int size;

    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * used to insert a node at the start of linked list
     *
     * @param data
     */
    public void insertAtFirst(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = head;
        new_node.prev = null;

        if(head!=null)
            head.prev = new_node;
        head = new_node;
        if(tail==null)
            tail=new_node;
        size++;
    }

    /**
     * used to insert a node at the start of linked list
     * @param data
     */
    public void insertLast(int data){
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        new_node.prev = tail;
        if(tail!=null)
            tail.next=new_node;
        tail = new_node;
        if(head==null)
            head=new_node;
        size++;
    }

    // used to delete node from start of Doubly linked list
    public Node deleteFirst() {

        if (size == 0)
            throw new RuntimeException("Doubly linked list is already empty");
        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp;
    }

    // used to delete node from last of Doubly linked list
    public Node deleteLast() {

        Node temp = tail;
        tail = tail.prev;
        tail.next=null;
        size--;
        return temp;
    }

    // Use to delete node after particular node
    public void deleteAfter(Node after) {
        Node temp = head;
        while (temp.next != null && temp.data != after.data) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next.next.prev=temp;
        temp.next = temp.next.next;

    }

    public void printLinkedListForward() {
        System.out.println("Printing Doubly LinkedList (head --> tail) ");
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println();
    }

    // For printing Doubly Linked List forward
    public void printLinkedListBackward() {
        System.out.println("Printing Doubly LinkedList (tail --> head) ");
        Node current = tail;
        while (current != null) {
            current.displayNodeData();
            current = current.prev;
        }
        System.out.println();
    }
}
