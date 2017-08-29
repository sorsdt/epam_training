package ua.epam.training.task5.exercise1_4;

import java.util.concurrent.RecursiveTask;

class RecursiveArrayAdder extends RecursiveTask<Integer> {
    private int from;
    private int to;
    private static int[] ints;

    private RecursiveArrayAdder(final int from, final int to) {
        this.from = from;
        this.to = to;
    }

    RecursiveArrayAdder(final int[] ints) {
        this(0, ints.length - 1);
        RecursiveArrayAdder.ints = ints;
    }

    @Override
    protected Integer compute() {
        if ((to - from) <= 20) {
            int localSum = 0;
            for (int i = from; i <= to; i++) {
                localSum += ints[i];
            }
//            System.out.println("Summing " + from + " " + to + " " + localSum);
            return localSum;
        } else {
            int mid = (from + to) / 2;
//            System.out.println("Forking " + from + " " + mid + " " + to);
            RecursiveArrayAdder firstHalf = new RecursiveArrayAdder(from, mid);
            firstHalf.fork();
            RecursiveArrayAdder secondPart = new RecursiveArrayAdder(++mid, to);
            int resultSecond = secondPart.compute();
            return firstHalf.join() + resultSecond;
        }
    }
}
