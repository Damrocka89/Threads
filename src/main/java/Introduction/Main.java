package Introduction;

import static Introduction.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_YELLOW + "Hello from the anonymous class");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from Runnable anonymous class implementation");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED+"Another Thread terminated or timed out so im running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all I was interrupted");
                }
            }
        });
        myRunnableThread.start();

        System.out.println(ANSI_PURPLE + "Hello again from main");

        ;


    }
}
