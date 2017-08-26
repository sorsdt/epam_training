package ua.epam.training.task5.exercise1_3;

import java.util.HashMap;
import java.util.Map;

public class ResourceHashMap extends Resource {
    private Map map;

    public ResourceHashMap(int initialCapacity, float loadFactor) {
        this.map = new HashMap(initialCapacity, loadFactor);
    }

    @Override
    synchronized String read(Integer key) {
        return map.get(key).toString();
    }

    @Override
    synchronized void write(Integer key, String value) {
        map.put(key, value);
    }
}
