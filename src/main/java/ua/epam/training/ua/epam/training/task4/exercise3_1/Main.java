package ua.epam.training.ua.epam.training.task4.exercise3_1;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = CollectionGenerator.getSet(-10, 10, 20);
        System.out.println(set);
        List<Integer> list = CollectionGenerator.getList(0, 10, 20);
        System.out.println(list);
    }
}
