package ua.epam.training.task5.exercise1_2;

public class SynchronizedResource implements Resource {
    private int amount = 0;
    private boolean flag = false;

    @Override
    synchronized public void print() {
        while (flag) {
            tryToWait();
        }
        System.out.print(amount + " ");
        flag = true;
        notify();
    }

    @Override
    synchronized public void increment() {
        while (!flag) {
            tryToWait();
        }
        amount++;
        flag = false;
        notify();
    }

    private void tryToWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
