import java.util.concurrent.Semaphore;

public class Count2b  extends  Thread{

    private static IntCell n = new IntCell();
    private static Semaphore semaphore = new Semaphore(1);

    @Override public void run() {
        int temp;
        for (int i = 0; i<200000; i++) {
            acquire();
            temp = n.getN();
            n.setN(temp + 1);
            semaphore.release();
        }
    }

    private void acquire() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Count2b p = new Count2b();
        Count2b q = new Count2b();
        p.start();
        q.start();
        try { p.join(); q.join(); }
        catch (InterruptedException e) { }
        System.out.println("The value of n is " + n.getN());
    }

}
