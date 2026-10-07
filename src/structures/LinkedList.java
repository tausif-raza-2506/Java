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
public class LinkedList {
    static Node head;

    public static void printChoiceList() {
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

    public static void printList() {
        for (Node temp = head; temp != null; temp = temp.next)
            System.out.print(temp.data + " -> ");
        System.out.println("null");
    }

    public static int size() {
        int count = 0;
        for (Node temp = head; temp != null; temp = temp.next) count++;
        return count;
    }

    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public static void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void insertAtIndex(int data, int index) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException("Invalid Index");

        if (index == 0) {
            insertAtStart(data);
            return;
        }

        if (index == size()) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.next;

        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public static void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If only one node is present
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) temp = temp.next;
        temp.next = null;
    }

    public static void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public static void deleteAtIndex(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException("Invalid Index");

        if (index == 0) {
            deleteFromStart();
            return;
        }

        if (index == size() - 1) {
            deleteFromEnd();
            return;
        }

        Node temp = head;
        for (int i = 0; temp.next != null && i < index - 1; i++)
            temp = temp.next;

        if (temp.next != null) temp.next = temp.next.next;
    }

    public static void reverseList() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice, val, index, k;
        do {
            printChoiceList();
            System.out.println("Enter choice");
            choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Insert at end mode, enter values to insert \n or Enter -1 to change choice");
                    while (true) {
                        System.out.println("Enter value");
                        val = in.nextInt();
                        if (val == -1) break;
                        insertAtEnd(val);
                        printList();
                    }
                }
                case 2 -> {
                    System.out.println("Insert at start mode, enter values to insert \n or Enter -1 to change choice");
                    while (true) {
                        System.out.println("Enter value");
                        val = in.nextInt();
                        if (val == -1) break;
                        insertAtStart(val);
                        printList();
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
                        insertAtIndex(val, index);
                        printList();
                    }
                }
                case 4 -> {
                    System.out.println("Delete from end mode");
                    while (true) {
                        System.out.print("Delete node from end? (Enter 1 to confirm or -1 leave");
                        val = in.nextInt();
                        if (val == -1) break;
                        deleteFromEnd();
                        printList();
                    }
                }
                case 5 -> {
                    System.out.println("Delete from start mode");
                    while (true) {
                        System.out.print("Delete node from start? (Enter 1 to confirm or -1 to leave");
                        val = in.nextInt();
                        if (val == -1) break;
                        deleteFromStart();
                        printList();
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
                        deleteAtIndex(index);
                        printList();
                    }
                }
                case 7 -> {
                    reverseList();
                    System.out.print("Reversed List : ");
                    printList();
                }
                default -> System.out.println("Invalid choice");
            }
            System.out.println("Enter 0 to exit to any other number to proceed with more operations");
            k = in.nextInt();
        }while (k!=0);
    }
}