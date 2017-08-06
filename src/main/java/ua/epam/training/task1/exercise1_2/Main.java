package ua.epam.training.task1.exercise1_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.print("Please input number greater then 2 or press q for quit:");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextLong()) {
                Long number = sc.nextLong();
                if (number > 0) {
                    PrimeNumbers.print(number);
                } else {
                    System.out.println("Number should be greater then 2");
                }
            } else {
                if (sc.hasNextLine()) {
                    if (sc.nextLine().equals("q")) {
                        break;
                    } else {
                        System.out.println("Not a number");
                    }
                }
            }
        }
    }
}
