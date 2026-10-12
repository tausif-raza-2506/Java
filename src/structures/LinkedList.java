package structures;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class DoubleNode extends Node {
    DoubleNode prev, next;

    public DoubleNode(int data) {
        super(data);
        this.prev = null;
    }
}

class SinglyLinkedList {
    Node head;
    int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            insertAtStart(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        size++;
    }

    public void insertAtIndex(int data, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index");

        if (index == 0) {
            insertAtStart(data);
            return;
        }

        if (index == size) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteFromEnd() {
        if (head == null || head.next == null) {
            deleteFromStart();
            return;
        }

        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid Index");

        if (index == 0) {
            deleteFromStart();
            return;
        }

        if (index == size - 1) {
            deleteFromEnd();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        if (temp.next != null) temp.next = temp.next.next;
        size--;
    }

    public void reverseList() {
        Node prev = null, next = null, current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printList() {
        for (Node temp = head; temp != null; temp = temp.next)
            System.out.print(temp.data + " -> ");
        System.out.println("null");
    }

    public void printChoiceList() {
        System.out.println(""" 
                    1. Insert from end
                    2. Insert from start
                    3. Insert at index
                    4. Delete from end
                    5. Delete from start
                    6. Delete from index
                    7. Reverse LinkedList
                """);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SinglyLinkedList l = new SinglyLinkedList();
        int choice, val, index, k;

        do {
            l.printChoiceList();
            System.out.println("Enter choice");
            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Insert at end mode, enter values to insert \n or Enter -1 to change choice");
                    while (true) {
                        System.out.println("Enter value");
                        val = in.nextInt();
                        if (val == -1) break;
                        l.insertAtEnd(val);
                        l.printList();
                    }
                }
                case 2 -> {
                    System.out.println("Insert at start mode, enter values to insert \n or Enter -1 to change choice");
                    while (true) {
                        System.out.println("Enter value");
                        val = in.nextInt();
                        if (val == -1) break;
                        l.insertAtStart(val);
                        l.printList();
                    }
                }
                case 3 -> {
                    System.out.println("Insert at index mode, enter values to insert \n or Enter -1 to change choice");
                    while (true) {
                        System.out.println("Enter value");
                        val = in.nextInt();
                        if (val == -1) break;
                        System.out.println("Enter index");
                        index = in.nextInt();
                        l.insertAtIndex(val, index);
                        l.printList();
                    }
                }
                case 4 -> {
                    System.out.println("Delete from end mode");
                    while (true) {
                        System.out.print("Delete node from end? (Enter 1 to confirm or -1 leave");
                        val = in.nextInt();
                        if (val == -1) break;
                        l.deleteFromEnd();
                        l.printList();
                    }
                }
                case 5 -> {
                    System.out.println("Delete from start mode");
                    while (true) {
                        System.out.print("Delete node from start? (Enter 1 to confirm or -1 to leave");
                        val = in.nextInt();
                        if (val == -1) break;
                        l.deleteFromStart();
                        l.printList();
                    }
                }
                case 6 -> {
                    System.out.println("Delete at index mode");
                    while (true) {
                        System.out.print("Delete node at index? (Enter 1 to confirm or -1 to leave");
                        val = in.nextInt();
                        if (val == -1) break;
                        System.out.println("Enter index");
                        index = in.nextInt();
                        l.deleteAtIndex(index);
                        l.printList();
                    }
                }
                case 7 -> {
                    System.out.print("Original List: ");
                    l.printList();
                    l.reverseList();
                    System.out.print("Reversed List : ");
                    l.printList();
                }
                default -> System.out.println("Invalid choice");
            }
            System.out.println("Enter 0 to exit to any other number to proceed with more operations");
            k = in.nextInt();
        }while (k!=0);
    }
}

class CircularLinkedList {
    Node head, tail;
    int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        if (tail == null) tail = head;
        tail.next = head;
        size++;
    }

    public void insertAtEnd(int data) {
        insertAtStart(data);
        tail = tail.next;
    }

    public void insertAtIndex(int data, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index");

        if (index == 0) {
            insertAtStart(data);
            return;
        }

        if (index == size) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
        tail.next = head;
        size--;
    }

    public void deleteFromEnd() {
        if (head == null || head == tail) {
            deleteFromStart();
            return;
        }

        Node temp = head;
        while (temp.next != tail) temp = temp.next;
        temp.next = head;
        tail = temp;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index");

        if (index == 0) {
            deleteFromStart();
            return;
        }

        if (index == size - 1) {
            deleteFromEnd();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;
        temp.next = temp.next.next;
        size--;
    }

    public void printList() {
        if(head == tail) {
            System.out.println("List in empty");
            return;
        }
        Node temp = head;
        System.out.print("Front -> ");
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Front");
    }
}

class DoublyLinkedList {
    DoubleNode head, tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtStart(int data) {
        DoubleNode newNode = new DoubleNode(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void insertAtEnd(int data) {
        if (head == null) {
            insertAtStart(data);
            return;
        }

        DoubleNode newNode = new DoubleNode(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void insertAtIndex(int data, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid Index");

        if (index == 0) {
            insertAtStart(data);
            return;
        }

        if (index == size) {
            insertAtEnd(data);
            return;
        }

        DoubleNode newNode = new DoubleNode(data);
        DoubleNode temp = head;

        for (int i = 0; i < index - 1; i++) temp = temp.next;

        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.next == null) {
            head = tail = null;
            size--;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteFromEnd() {
        if (head == null || head == tail) {
            deleteFromStart();
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteFromIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid Index");

        if (index == 0) {
            deleteFromStart();
            return;
        }

        if (index == size - 1) {
            deleteFromEnd();
            return;
        }

        DoubleNode temp = head;
        for (int i = 0; i < index; i++) temp = temp.next;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }

        DoubleNode current = head, temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("null <- ");
        for (DoubleNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" <-> ");
        }
        System.out.println(" -> null");
    }
}

public class LinkedList {
    public static void main(String[] args) {

    }
}