package Lecture;

public class PrintThread extends Thread {

    private int sleepTime;

    public PrintThread(String name) {
        super(name);
        sleepTime = (int) (Math.random() * 5000); //sleep 0-5s
        System.out.println("Name: " + getName() + "; sleep: " + sleepTime);
    }

    @Override public void run() {
        try {
            System.out.println(getName() + " going to sleep");
            Thread.sleep(sleepTime);
        } catch ( InterruptedException e ) {
            System.out.println( e.toString() );
        }
        System.out.println(getName() + " done sleeping");
    }
}
