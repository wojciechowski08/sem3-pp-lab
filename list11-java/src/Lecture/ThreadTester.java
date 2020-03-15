package Lecture;

public class ThreadTester {

    public static void main(String[] args) {

        PrintThread t1, t2, t3, t4;
        t1 = new PrintThread("t1");
        t2 = new PrintThread("t2");
        t3 = new PrintThread("t3");
        t4 = new PrintThread("t4");

        System.out.println("\nStarting threads");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("Threads started\n");
    }

}
