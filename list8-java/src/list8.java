import java.util.ArrayList;
import java.util.List;

public class list8 {



}

public interface MyQueue<E> {
    public void enqueue(E x) throws FullException;
    public void dequeue();
    public E first() throws EmptyException;
    public boolean isEmpty();
    public boolean isFull();
}
public class FullException extends Exception {
    public FullException() {

    }

    public FullException(String message) {
        super(message);
    }
}
public class EmptyException extends Exception {
    public EmptyException() { }
    public EmptyException(String message) {
        super(message);
    }
}

public class CyclicArrayQueue<E> implements MyQueue<E> {

    private List<E> queue;
    private int f = 0, r = 0;

    private CyclicArrayQueue(int n) {
        queue = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            queue.add(null);
        }
    }

    public void enqueue(E x) throws FullException {
        if ( isFull() ) {
            throw new FullException("CyclicArrayQueue: enqueue");
        } else {
            queue.set(r, x);
            r = (r + 1) % queue.size();
        }
    }

    public void dequeue() {
        if ( !isEmpty() ) {
            f = (f + 1) % queue.size();
        }
    }

    public E first() throws EmptyException {
        if ( isEmpty() ) {
            throw new EmptyException("CyclicArrayQueue: first");
        } else {
            return queue.get(f);
        }
    }

    public boolean isEmpty() {
        return f == r;
    }

    public boolean isFull() {
        return (r + 1) % queue.size() == f;
    }


}

//public static void main(String[] args) throws FullException, EmptyException {
//    MyQueue<String> q = new CyclicArrayQueue<>(3);
//}
