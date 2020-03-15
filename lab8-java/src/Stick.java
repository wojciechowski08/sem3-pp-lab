import java.util.concurrent.Semaphore;

class Stick {
    private final Semaphore state = new Semaphore(1);

    void take() throws InterruptedException {
        state.acquire();
    }

    void release() {
        state.release();
    }
}
