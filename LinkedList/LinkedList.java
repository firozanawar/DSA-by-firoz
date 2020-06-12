package LinkedList;

public class LinkedList {

    Node head;

    static class Node {

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

    /**
     * Append the data
     *
     * @param new_data
     */
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

    private boolean isPalindrome(Node head) {
        boolean isPalindrome = true;

        Node middleElement = middleElementM2(head);

        Node secondHead = middleElement.next;
        middleElement.next = null;

        Node reverseSecondHead = reversByRecursive(secondHead);
        while (head != null && reverseSecondHead != null) {

            if (head.data == reverseSecondHead.data) {
                head = head.next;
                reverseSecondHead = reverseSecondHead.next;
                continue;
            } else {
                isPalindrome = false;
            }
        }

        return isPalindrome;

    }

    /**
     * Time complexity=time for finding length of list + time for locating middle element=o(n)+o(n) =o(n)
     * Space complexity= o(1).
     *
     * @param head
     */
    private void middleElementM1(Node head) {
        int lenght = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            lenght++;
        }
        //System.out.println("LinkedList length is: " + lenght);

        Node temp = head;
        for (int i = 0; i < lenght / 2; i++) {
            temp = temp.next;
        }
        System.out.println("Middle element brute fore is: " + temp.data);

    }

    private Node middleElementM2(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element using 2 pointer is: " + slow.data);
        return slow;
    }

    private void nthElementFromEndM1(Node head, int n) {
        int lenght = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            lenght++;
        }

        if (n > lenght) return;

        Node temp = head;
        for (int i = 1; i < lenght - n + 1; i++) {
            temp = temp.next;
        }

        System.out.println(n + "th element from end is using M1: " + temp.data);
    }

    private void nthElementFromEndM2(Node head, int n) {

        // TODO: 21/04/20 - Handle basic cases 
        Node first = head;
        Node second = head;
        for (int i = 1; i <= n; i++) {
            second = second.next;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }
        System.out.println(n + "th element from end is using M2: " + first.data);
    }

    private boolean ifLoopExists() {
        Node fastPtr = head;
        Node slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return true;

        }
        return false;
    }

    public Node findStartNodeOfTheLoop() {
        Node fastPtr = head;
        Node slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }

        }
        if (loopExists) {
            slowPtr = head;

            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }


        } else {
            System.out.println("Loop does not exists");
            slowPtr = null;
        }
        return slowPtr;
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

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    /**
     * Find the length of both singly linked lists.
     * Find the bigger linked list and iterate up to the difference between two linked list.
     * Please note that two linked list will become equal at this step.
     * Iterate over both linked list and check if there is any common node, if you find one, return it.
     * Else return null.
     */
    public Node findIntersectionNode(Node list1, Node list2) {

        int lengthOfList1 = 0;
        int lengthOfList2 = 0;

        Node temp1 = list1;
        Node temp2 = list2;

        while (temp1 != null) {
            lengthOfList1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            lengthOfList2++;
            temp2 = temp2.next;
        }

        int difference = 0;
        Node ptr1 = list1;
        Node ptr2 = list2;

        if (lengthOfList1 > lengthOfList2) {
            difference = lengthOfList1 - lengthOfList2;
            int i = 0;
            while (i < difference) {
                ptr1 = ptr1.next;
                i++;
            }
        } else if (lengthOfList1 < lengthOfList2) {
            difference = lengthOfList2 - lengthOfList1;
            int i = 0;
            while (i < difference) {
                ptr2 = ptr2.next;
                i++;
            }
        }

        while (ptr1 != null && ptr2 != null) {

            if (ptr1 == ptr1)
                return ptr1;

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return null;
    }

    private Node reverseInPair(Node head) {
        Node curr = head;
        Node temp = null;
        Node newHead = null;

        while (curr != null && curr.next != null) {

            if (temp != null) {
                temp.next.next = curr.next;
            }

            temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;

            if (newHead == null)
                newHead = temp;
            curr = curr.next;
        }


        return newHead;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertAtBeginning(1);
        linkedList.insertAtBeginning(2);
        linkedList.insertAtBeginning(3);
        linkedList.insertAtBeginning(4);
        linkedList.insertAtBeginning(5);

//        linkedList.insertAtEnd(1);
//        linkedList.insertAtEnd(2);
//        linkedList.append(1);
//        linkedList.append(60);
//        linkedList.append(70);
//        linkedList.append(80);

        linkedList.printList();

        System.out.println();
        linkedList.reversByIterative(linkedList.head);


        linkedList.printListUsingHead(linkedList.reverseInPair(linkedList.head));
        System.out.println();

        linkedList.middleElementM1(linkedList.head);
        linkedList.middleElementM2(linkedList.head);

        System.out.println();
//        linkedList.nthElementFromEndM1(linkedList.head, 2);
//        linkedList.nthElementFromEndM2(linkedList.head, 2);

        System.out.println();
        System.out.println("Is Palindrome: " + linkedList.isPalindrome(linkedList.head));

        System.out.println();
        Node newHead = linkedList.reversByRecursive(linkedList.head);
        linkedList.printListUsingHead(newHead);
        System.out.println();
        System.out.println("Linkedlist count is: " + linkedList.getCount(newHead));




        /******** Detect loop and final start loop point *********/
        // Creating a looped linked list
        /*Node loopNode=new Node(7);
        linkedList.addToTheLast(new Node(5));
        linkedList.addToTheLast(new Node(6));
        linkedList.addToTheLast(loopNode);
        linkedList.addToTheLast(new Node(1));
        linkedList.addToTheLast(new Node(2));

        linkedList.printList();
        linkedList.addToTheLast(loopNode);

        Node startNode=linkedList.findStartNodeOfTheLoop();
        if(startNode!=null)
            System.out.println("start Node of loop is "+ startNode.data);*/

        /******** Intersection point and data *********/
        // Creating a linked list
        /*Node head1=new Node(5);
        linkedList.addToTheLast(head1);
        linkedList.addToTheLast(new Node(6));
        Node node = new Node(7);
        linkedList.addToTheLast(node);
        linkedList.addToTheLast(new Node(1));
        linkedList.addToTheLast(new Node(2));

        LinkedList list2 = new LinkedList();
        Node head2=new Node(4);
        list2.addToTheLast(head2);
        list2.addToTheLast(node);

        Node findIntersectionNode = linkedList.findIntersectionNode(head1, head2);
        if(findIntersectionNode==null)
        {
            System.out.println("Two linked lists do not intersect!!");
        }
        else
        {
            System.out.println("Intersecting node: "+findIntersectionNode.data);
        }*/
    }
}
