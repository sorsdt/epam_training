package ua.epam.training.task5.exercise1_2;

public class Printer implements Runnable {
    private Resource resource;

    public Printer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            resource.print();
            if (resource instanceof SynchronizedResource) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
