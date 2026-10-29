package structures;

class DequeLinkedList {
    DoublyLinkedList l = new DoublyLinkedList();

    public void addFirst(int data) {
        l.insertAtStart(data);
    }

    public void addLast(int data) {
        l.insertAtEnd(data);
    }

    public void removeFirst() {
        l.deleteFromStart();
    }

    public void removeLast() {
        l.deleteFromEnd();
    }

    public int peekFirst() {
        if(l.head == null) throw new RuntimeException("Deque is empty");
       return l.head.data;
    }

    public int peekLast() {
        if(l.tail == null) throw new RuntimeException("Deque is empty");
        return l.tail.data;
    }

    public void printDeque() {
        var current = l.head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null)
                System.out.print(", ");
            current = current.next;
        }
        System.out.println("]");
    }

    public int size() {
        return l.size;
    }
}

public class Deque {
    public static void main(String[] args) {
        DequeLinkedList l = new DequeLinkedList();
        l.addFirst(10);
        l.addFirst(20);
        l.addFirst(30);
        l.addLast(5);
        l.addLast(15);
        l.addLast(25);
        l.printDeque();
        System.out.println("First element : " + l.peekFirst());
        System.out.println("Last element : " + l.peekLast());
        System.out.println(l.size());
        l.removeFirst();
        l.removeLast();
        l.printDeque();
        System.out.println(l.size());
    }
}
