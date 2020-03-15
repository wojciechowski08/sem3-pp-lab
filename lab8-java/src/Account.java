import java.util.Random;
import java.util.concurrent.Semaphore;

class Account{

    private static int balance = 10000;
    private static Semaphore semaphore = new Semaphore(1);


    public static void main( String[] args) {

        Transaction t1, t2;

        t1 = new Transaction("coming", 1);
        t2 = new Transaction("withdrawal", -1);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Transaction extends Thread{


//        private static Semaphore semaphore = new Semaphore(1);
        private static Account account;
        private int type;
        private static final Random random = new Random();


        public Transaction(String name, int type) {

            super(name);
            this.type = type;
        }

        public void noTransaction() throws InterruptedException {
            sleep(random.nextInt(1000));
        }

        public void makeTransaction() throws InterruptedException {
//            semaphore.acquire();
            System.out.println(currentThread().getName() + " transaction in progress");
            System.out.println(balance + " balance before");
            int temp = random.nextInt(3000)*type;
            balance = balance + temp;
            System.out.println(balance + " balance after");
            System.out.println(currentThread().getName() + " transaction finished");
//            semaphore.release();
        }

        @Override public void run() {
            try {
                int n = 0;
                System.out.println("Starting");
                while (n <= 10) {
                    noTransaction();
                    makeTransaction();
                    n++;
                }
                System.out.println("Finished");
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }


    }




}


