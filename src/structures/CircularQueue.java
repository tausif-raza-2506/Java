package structures;

class CircularQueueArray {
    int front, rear, size, capacity;
    int[] arr;

    public CircularQueueArray(int capacity) {
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Cannot insert! Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Cannot delete! Queue is empty");
            return;
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Removed " + val);
    }

    public void peek() {
        System.out.println(size == 0 ? "Cannot peek! Queue is empty" : arr[front]);
    }
}

class CircularQueueLinkedList {
    CircularLinkedList l = new CircularLinkedList();

    public void enqueue(int data) {
        l.insertAtEnd(data);
    }

    public void dequeue() {
      l.deleteFromStart();
    }

    public void peek() {
        System.out.println(l.head == null ? "Cannot peek! Queue is empty" : "Front element is: " + l.head.data);
    }

    public void printQueue() {
        l.printList();
    }
}

public class CircularQueue {
    public static void main(String[] args) {
        CircularQueueLinkedList l = new CircularQueueLinkedList();
        l.enqueue(10);
        l.enqueue(20);
        l.dequeue();
        l.enqueue(30);
        l.enqueue(40);
        l.dequeue();
        l.printQueue();
        l.peek();
    }
}