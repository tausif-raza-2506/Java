package structures;
public class Queue {

    public void enqueue(int data) {
        SinglyLinkedList.insertAtEnd(data);
        printQueue();
    }

    public void dequeue() {
        SinglyLinkedList.deleteFromStart();
        printQueue();
    }

    public void peek() {
        System.out.println(SinglyLinkedList.head == null ? "Cannot peek! Queue is empty" : "Front element is: " + SinglyLinkedList.head.data);
    }

    public void printQueue() {
        SinglyLinkedList.printList();
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