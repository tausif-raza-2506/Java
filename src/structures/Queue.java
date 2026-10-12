package structures;
public class Queue {
    SinglyLinkedList l = new SinglyLinkedList();

    public void enqueue(int data) {
        l.insertAtEnd(data);
        printQueue();
    }

    public void dequeue() {
        l.deleteFromStart();
        printQueue();
    }

    public void peek() {
        System.out.println(l.head == null ? "Cannot peek! Queue is empty" : "Front element is: " + l.head.data);
    }

    public void printQueue() {
        l.printList();
    }

    public static void main(String[] args) {
        Queue l = new Queue();
        l.enqueue(10);
        l.enqueue(20);
        l.dequeue();
        l.enqueue(30);
        l.enqueue(40);
        l.dequeue();
        l.peek();
    }
}