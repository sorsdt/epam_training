package ua.epam.training.task4.exercise3_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionGenerator {
    public static Set<Integer> getSet(final int begin, final int end, final int count) {
        if (end <= begin) throw new IllegalArgumentException(end + " must be bigger then " + begin);
        if (count > end - begin + 1)
            throw new IllegalArgumentException(count + " is bigger then range:" + begin + "," + end);
        Set set = new HashSet();
        while (set.size() < count) {
            set.add(begin + (int) (Math.random() * (end - begin + 1)));
        }
        return set;
    }

    public static List<Integer> getList(final int begin, final int end, final int count) {
        if (end <= begin) throw new IllegalArgumentException(end + " must be bigger then " + begin);
        List list = new ArrayList();
        while (list.size() < count) {
            list.add(begin + (int) (Math.random() * (end - begin + 1)));
        }
        return list;
    }
}
