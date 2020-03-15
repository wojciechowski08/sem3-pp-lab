package Lecture.ProdCons;

public class Consumer extends Thread {

//    private Buffer buf;
//
//    public Consumer(String name, Buffer buf) {
//        super(name);
//        this.buf = buf;
//    }
//
//    @Override public void run() {
//        String msg = "";
//        do {
//            msg = buf.take();
//        } while (!msg.equals("Done"));
//    }

    final private Consume buf;

    public Consumer(String name, Consume buf) {
        super(name);
        this.buf = buf;
    }

    @Override public void run() {
        for (int i=1; 1 <= 10; i++) {
            System.out.println(getName()+ " consumed " +buf.take());
        }
    }

}
