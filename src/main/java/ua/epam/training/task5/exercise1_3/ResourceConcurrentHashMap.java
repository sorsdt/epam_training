package ua.epam.training.task5.exercise1_3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceConcurrentHashMap extends Resource {
    private Map map;

    public ResourceConcurrentHashMap(int initialCapacity, float loadFactor) {
        this.map = new ConcurrentHashMap(initialCapacity, loadFactor);
    }

    @Override
    String read(Integer key) {
        return map.get(key).toString();
    }

    @Override
    void write(Integer key, String value) {
        map.put(key, value);
    }
}
