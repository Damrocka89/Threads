package DeadLocks;

public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Has lock1!");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1 waiting fot lock 2");
                synchronized (lock2) {
                    System.out.println("Thread1 has lock 1 and lock 2");
                }
                System.out.println("Thread 1 released lock1");
            }
            System.out.println("Thread1 released lock 1. Exiting");
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 2: Has lock1!");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2 waiting fot lock 2");
                synchronized (lock2) {
                    System.out.println("Thread2 has lock 1 and lock 2");
                }
                System.out.println("Thread 2 released lock2");
            }
            System.out.println("Thread2 released lock 1. Exiting");
        }
    }
}


