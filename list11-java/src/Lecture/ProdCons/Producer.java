package Lecture.ProdCons;

public class Producer extends Thread {

//    private Buffer buf;
    final private Lecture.ProdCons.Produce buf;

//    public Producer(String name, Buffer buf) {
//        super(name);
//        this.buf = buf;
//    }
//
//    @Override public void run() {
//        for (int i=1; i<=10; i++) {
//            buf.put("m" + i);
//        }
//        buf.put("Done");
//    }

    public Producer(String name, Lecture.ProdCons.Produce buf) {
        super(name);
        this.buf = buf;
    }

    @Override public void run() {
        for (int i=1; i<=10; i++) {
            System.out.println(getName() + " producing " + i);
            buf.put(i);
        }
    }
}
