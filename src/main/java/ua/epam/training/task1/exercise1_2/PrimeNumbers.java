package ua.epam.training.task1.exercise1_2;

public class PrimeNumbers {
    public static void print(long number) {
        boolean noResult = true;
        for (long i = 1; i < number; i++) {
            long sum = 0;
            for (long j = 1; j < i; j++) {
                if (i % j == 0)
                    sum = sum + j;
            }
            if (i == sum) {
                System.out.println(i);
                noResult = false;
            }
        }
        if (noResult) {
            System.out.println("There is no results in current range");
        }
    }
}
