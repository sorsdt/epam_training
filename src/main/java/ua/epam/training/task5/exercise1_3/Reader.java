package ua.epam.training.task5.exercise1_3;

public class Reader implements Runnable {
    private Resource resource;
    private int iterationsCount;

    public Reader(Resource resource, int iterationsCount) {
        this.resource = resource;
        this.iterationsCount = iterationsCount;
    }

    @Override
    public void run() {
//        List list = new ArrayList(iterationsCount);
        for (int i = 0; i < iterationsCount; i++) {
//            list.add(resource.read(i));
            resource.read(i);
        }
//        System.out.println(list);
    }
}

