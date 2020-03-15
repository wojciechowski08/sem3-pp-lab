public class IntCell2a {

    private int n = 0;
    private boolean isSet = true;

    public synchronized int getN() {
        while (!isSet) {
            waitForNotice();
        }
        isSet = false;
        notifyAll();
        return n;
    }

    public synchronized void setN(int n) {
        while (isSet) {
            waitForNotice();
        }
        this.n = n;
        isSet = true;
        notifyAll();
    }

    private void waitForNotice() {
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}
