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
    Node front, rear;
    int size;

    public CircularQueueLinkedList() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if(front == null) front = newNode;
        else rear.next = newNode;

        rear = newNode;
        rear.next = front;
        size++;
        printQueue();
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Cannot remove. Queue is empty");
            return;
        }
        if (front == rear) {
            front = null;
            rear = null;
            return;
        }
        int val = front.data;
        front = front.next;
        rear.next = front;
        size--;
        printQueue();
    }

    public void peek() {
        System.out.println(front == null ? "Cannot peek! Queue is empty" : "Front element is: " + front.data);
    }

    public void printQueue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        System.out.print("front -> ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != front);
        System.out.println("front");
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
        l.peek();
    }
}