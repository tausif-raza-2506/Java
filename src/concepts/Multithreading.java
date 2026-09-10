package concepts;

/** Multithreading by Implementing Runnable Interface.
    Preferred Method as we can implement multiple interfaces. */

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++)
            System.out.println("Thread 1 / Runnable interface");
    }
}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++)
            System.out.println("Thread 2 / Runnable interface");
    }
}

/** Multithreading by extending Thread Class.
   Less preferred as we can't extend any other class. */
class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++)
            System.out.println("Thread 1 / Thread class");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5000; i++)
            System.out.println("Thread 2 / Thread class");
    }
}

public class Multithreading {
    public static void main(String[] args) {

        // For using Runnable Interface
        MyRunnable1 runnable1 = new MyRunnable1();
        Thread t1 = new Thread(runnable1);
        t1.start();

        MyRunnable2 runnable2 = new MyRunnable2();
        Thread t2 = new Thread(runnable2);
        t2.start();

        // For using Thread Class
        MyThread1 t3 = new MyThread1();
        MyThread2 t4 = new MyThread2();
        t3.start();     t4.start();
    }
}
