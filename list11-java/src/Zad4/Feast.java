package Zad4;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Feast {

    private static final int iPhilosophers = 5;
    private static final Random random = new Random();
    private static final Semaphore doorman = new Semaphore(4, true);
    private static final Stick[] sticks = new Stick[5];

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            sticks[i] = new Stick();
        Philosopher[] philosophers = new Philosopher[iPhilosophers];
        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i);
            philosophers[i].start();
        }
    }

    static class Philosopher extends Thread {
        private final Stick left, right;

        Philosopher(int number) {
            super("Philosopher" + number);
            right = sticks[number];
            left = sticks[(number + 1) % iPhilosophers];
        }

        void meditate() throws InterruptedException {
            System.out.println(getName() + " is meditating");
            sleep(random.nextInt(10000));
            System.out.println(getName() + " has finished meditating");
            eat();
        }

        void eat() throws InterruptedException {
            doorman.acquire();
            left.take();
            right.take();
            System.out.println(getName() + " is eating");
            sleep(random.nextInt(10000));
            left.release();
            right.release();
            doorman.release();
            meditate();
        }

        @Override public void run() {
            try {
                meditate();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
