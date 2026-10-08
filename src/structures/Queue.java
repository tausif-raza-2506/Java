package structures;
public class Queue {

    public void enqueue(int data) {
        LinkedList.insertAtEnd(data);
        printQueue();
    }

    public void dequeue() {
        LinkedList.deleteFromStart();
        printQueue();
    }

    public void peek() {
        System.out.println(LinkedList.head == null ? "Cannot peek! Queue is empty" : "Front element is: " + LinkedList.head.data);
    }

    public void printQueue() {
        LinkedList.printList();
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