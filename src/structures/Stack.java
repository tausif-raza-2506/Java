package structures;
class StackLinkedList {
    SinglyLinkedList l = new SinglyLinkedList();

    public void push(int data) {
        l.insertAtStart(data);
    }

    public void pop() {
        l.deleteFromStart();
    }

    public int peek() {
        if(l.head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return l.head.data;
    }

    public void printStack() {
        l.printList();
    }

    public int size() {
        return l.size;
    }
}

class StackArray {
    int top, size;
    int[] arr;

    public StackArray(int size) {
        this.top = -1;
        this.size = size;
        this.arr = new int[size];
    }

    public void push(int data) {
        if(top == size - 1) throw new StackOverflowError("Stack Overflow");
        arr[++top] = data;
    }

    public void pop() {
        if(top == -1) throw new IllegalStateException("Stack Underflow");
        arr[top--] = 0;
    }

    public int peek() {
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public void printStack() {
        for(int n : arr) System.out.print(n + " ");
    }

    public static void main(String[] args) {
        StackArray s = new StackArray(4);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        s.pop();
        s.pop();

        System.out.println("Top Element = " + s.peek());
        System.out.println("Size = " + s.size());
        s.printStack();
    }
}

public class Stack {
    public static void main(String[] args) {

    }
}
