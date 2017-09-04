package ua.epam.training.task5.exercise1_3;

import java.util.concurrent.CountDownLatch;

public class Reader implements Runnable {
    private Resource resource;
    private int iterationsCount;
    private CountDownLatch latch;

    Reader(Resource resource, int iterationsCount, CountDownLatch latch) {
        this.resource = resource;
        this.iterationsCount = iterationsCount;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < iterationsCount; i++) {
            resource.read(i);
        }
    }
}

