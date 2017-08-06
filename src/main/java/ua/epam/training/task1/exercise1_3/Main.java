package ua.epam.training.task1.exercise1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Please input positive digit in range 1-9 or press q for quit:");
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
            if (str.equals("q")) break;
            int level = Integer.parseInt(str);
            if ((level >= 1) && (level <= 9)) {
                int spaceCount = level;
                int digitCount = 0;
                for (int i = 1; i <= level; i++) {
                    for (int j = 1; j < spaceCount; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= digitCount; j++) {
                        System.out.print(j);
                    }
                    System.out.print(i);
                    for (int j = digitCount; j >= 1; j--) {
                        System.out.print(j);
                    }
                    System.out.println();
                    spaceCount--;
                    digitCount++;
                }
            } else {
                System.out.println("Number is in wrong range");
            }
        }
    }
}
