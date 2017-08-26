package ua.epam.training.task5.exercise1_3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static final int WRITER_COUNT = 2;
    public static final int READER_COUNT = 2;
    public static final int THREAD_COUNT = WRITER_COUNT + READER_COUNT;
    public static final int ITERATIONS = 1000;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;


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
        long start = System.currentTimeMillis();
        doWork(pool, futures, resourceHashMap);
        long diff = System.currentTimeMillis() - start;
        System.out.println("HashMap: " + diff);

        start = System.currentTimeMillis();
        doWork(pool, futures, resourceConcurrentHashMap);
        diff = System.currentTimeMillis() - start;
        System.out.println("ConcurrentHashMap: " + diff);

        pool.shutdownNow();
    }

    private static void doWork(ExecutorService pool, Future[] futures, Resource resource) throws InterruptedException, ExecutionException {
        for (int i = 0; i < WRITER_COUNT; ++i) {
            futures[i] = pool.submit(new Writer(resource, ITERATIONS));
        }
        for (int i = WRITER_COUNT; i < THREAD_COUNT; ++i) {
            futures[i] = pool.submit(new Reader(resource, ITERATIONS));
        }
        for (int i = 0; i < THREAD_COUNT; ++i) {
            futures[i].get();
        }
    }
}
