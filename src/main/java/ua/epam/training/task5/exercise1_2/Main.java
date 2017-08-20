package ua.epam.training.task5.exercise1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Press 1 for execution unsynchronized variant or 2 for synchronized one:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Resource resource;
        switch (s) {
            default: {
                System.out.println("Спробуйте ще");
                System.exit(0);
            }
            case "1": {
                resource = new UnSynchronizedResource();
                break;
            }
            case "2": {
                resource = new SynchronizedResource();
                break;
            }
        }
        Thread counterThread = new Thread(new Incrementer(resource, 1_000_000));
        Thread printerThread = new Thread(new Printer(resource));
        printerThread.setDaemon(true);
        counterThread.start();
        printerThread.start();
    }
}
