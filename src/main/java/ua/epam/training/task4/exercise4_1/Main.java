package ua.epam.training.task4.exercise4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static final int MIN_Range = 2;
    public static final int MIN_SETS_COUNT_N = 2;
    public static final int MIN_POINTS_COUNT_M = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input N:");
        final int setsCountN = Integer.parseInt(reader.readLine());
        System.out.println("Please input M:");
        final int pointsCountM = Integer.parseInt(reader.readLine());

        if ((setsCountN > MIN_SETS_COUNT_N) && (pointsCountM > MIN_POINTS_COUNT_M)) {
            int range = MIN_Range;
            Set<Set<Point>> sets = new HashSet<>();
            Set<Point> firstPointSet = new HashSet<>();
            Random random = new Random();
            int i = 0;
            while (i < setsCountN) {
                Set<Point> points = new HashSet<>();
                int j = 0;
                while (j < pointsCountM) {
                    if (points.add(new Point(random.nextInt(range), random.nextInt(range)))) {
                        j++;
                    } else {
                        range++;
                    }
                }
                if (sets.add(points)) {
                    if (i == 0) {
                        firstPointSet = points;
                    }
                    i++;
                } else {
                    range++;
                }
            }

            sets.remove(firstPointSet);
            Point resultPoint = null;
            int resultPointCount = 0;

            for (Point currentPoint : firstPointSet) {
                int localPointCounter = 0;
                for (Set<Point> pointSet : sets) {
                    if (pointSet.contains(currentPoint)) {
                        localPointCounter++;
                    }
                }
                if (localPointCounter > resultPointCount) {
                    resultPointCount = localPointCounter;
                    resultPoint = currentPoint;
                }
            }

            System.out.println("First set - " + firstPointSet);
            System.out.println("Another sets - " + sets);
            if (resultPointCount > 0) {
                System.out.println("Searched point - " + resultPoint);
            } else {
                System.out.println("There is no suitable results");
            }
        } else {
            System.out.println("Wrong input");
        }
    }
}