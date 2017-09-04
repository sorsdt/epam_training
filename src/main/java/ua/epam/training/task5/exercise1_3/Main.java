package ua.epam.training.task5.exercise1_3;

import java.util.concurrent.*;

public class Main {
    private static final int WRITER_COUNT = 2;
    private static final int READER_COUNT = 2;
    private static final int THREAD_COUNT = WRITER_COUNT + READER_COUNT;
    private static final int ITERATIONS = 1000;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
        Future[] futures = new Future[THREAD_COUNT];
        Resource resourceHashMap = new ResourceHashMap(ITERATIONS, DEFAULT_LOAD_FACTOR);
        Resource resourceConcurrentHashMap = new ResourceConcurrentHashMap(ITERATIONS, DEFAULT_LOAD_FACTOR);
        String currentThreadId = String.valueOf(Thread.currentThread().getId());
        for (int i = 0; i < ITERATIONS; i++) {
            resourceHashMap.write(i, currentThreadId);
            resourceConcurrentHashMap.write(i, currentThreadId);
        }
        System.out.println("HashMap: " + doWork(pool, futures, resourceHashMap));
        System.out.println("ConcurrentHashMap: " + doWork(pool, futures, resourceHashMap));
        pool.shutdownNow();
    }

    private static long doWork(ExecutorService pool, Future[] futures, Resource resource) throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < WRITER_COUNT; ++i) {
            futures[i] = pool.submit(new Writer(resource, ITERATIONS, latch));
        }
        for (int i = WRITER_COUNT; i < THREAD_COUNT; ++i) {
            futures[i] = pool.submit(new Reader(resource, ITERATIONS, latch));
        }
        long start = System.currentTimeMillis();
        latch.countDown();
        for (int i = 0; i < THREAD_COUNT; ++i) {
            futures[i].get();
        }
        return System.currentTimeMillis() - start;
    }
}
