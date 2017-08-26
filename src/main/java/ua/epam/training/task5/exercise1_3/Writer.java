package ua.epam.training.task5.exercise1_3;

import java.util.Random;

public class Writer implements Runnable {
    private Resource resource;
    private int iterationsCount;

    public Writer(Resource resource, int iterationsCount) {
        this.resource = resource;
        this.iterationsCount = iterationsCount;
    }

    @Override
    public void run() {
        Random random = new Random();
        String currentThreadId = String.valueOf(Thread.currentThread().getId());
        for (int i = 0; i < iterationsCount; i++) {
            resource.write(random.nextInt(iterationsCount), currentThreadId);
        }
    }
}
