package Lecture;

public class Counter2 implements Runnable{

    protected int count, inc, delay;

    public Counter2(int init, int inc, int delay) {
        this.count = init;
        this.inc = inc;
        this.delay = delay;
    }

    @Override public void run() {
        try{
            for (int i=0; i<30; i++) {
                System.out.print(count + " ");
                count += inc;
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) {
        new Thread(new Counter2(0, 1, 33)).start();
        new Thread(new Counter2(0, -1, 100)).start();

    }

}
