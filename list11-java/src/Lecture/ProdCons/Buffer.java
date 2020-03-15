package Lecture.ProdCons;

public class Buffer {

    private String msg;
    private boolean empty = true;

    public synchronized void put(String msg) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        System.out.println(Thread.currentThread().getName() + " puts " + msg);
        this.msg = msg;
        empty = false;
        notifyAll();
    }

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + msg);
        return msg;
    }

}
