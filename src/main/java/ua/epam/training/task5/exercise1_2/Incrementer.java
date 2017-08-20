package ua.epam.training.task5.exercise1_2;

public class Incrementer implements Runnable {
    private Resource resource;
    private int range;

    Incrementer(Resource resource, int range) {
        this.resource = resource;
        this.range = range;
    }

    @Override
    public void run() {
        for (int i = 0; i < range; i++) {
            resource.increment();
        }
    }
}
