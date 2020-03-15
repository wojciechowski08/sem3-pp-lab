class Count extends Thread {

//    private static IntCell n = new IntCell();
    private static IntCell2a n = new IntCell2a();

    @Override public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
//            if (i%1000==0) {System.out.println("Step");
            temp = n.getN();
            n.setN(temp + 1);
        }
    }

    public static void main(String[] args) {
        Count p = new Count();
        Count q = new Count();
        p.start();
        q.start();
        try { p.join(); q.join(); }
        catch (InterruptedException e) { }
        System.out.println("The value of n is " + n.getN());
    }
}
