package ua.epam.training.task5.exercise1_3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Writer implements Runnable {
    private Resource resource;
    private int iterationsCount;
    private CountDownLatch latch;

    Writer(Resource resource, int iterationsCount, CountDownLatch latch) {
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
        Random random = new Random();
        String currentThreadId = String.valueOf(Thread.currentThread().getId());
        for (int i = 0; i < iterationsCount; i++) {
            resource.write(random.nextInt(iterationsCount), currentThreadId);
        }
    }
}
