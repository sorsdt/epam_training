package ua.epam.training.task5.exercise1_2;

public class UnSynchronizedResource implements Resource {
    private int amount = 0;

    @Override
    public void print() {
        System.out.print(amount + " ");
    }

    @Override
    public void increment() {
        amount++;
    }
}
