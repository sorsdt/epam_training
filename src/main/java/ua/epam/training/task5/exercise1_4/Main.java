package ua.epam.training.task5.exercise1_4;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private final static int RANGE = 100;
    private final static int THREAD_COUNT = 8;
    private final static int N = 1_000_000;

    public static void main(String[] args) {
        System.out.println("Computed result:" + getArraySum(generateArray()));
    }

    static int getArraySum(final int[] ints) {
        ForkJoinPool pool = new ForkJoinPool(THREAD_COUNT);
        return pool.invoke(new RecursiveArrayAdder(ints));
    }

    static int[] generateArray() {
        Random random = new Random();
        int[] ints = new int[N];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(RANGE);
        }
        return ints;
    }
}
