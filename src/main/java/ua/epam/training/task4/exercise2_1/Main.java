package ua.epam.training.task4.exercise2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        Class<?> clazz = String.class;
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        String originString = "test";
        System.out.println(originString);
        String newString = "passed";
        field.set(originString, newString.toCharArray());
        System.out.println(originString);
        System.out.println("test");//miracle

        System.out.println("Please make some input:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String originInputedString = reader.readLine();
        System.out.println(originInputedString);
        System.out.println("Please enter new value:");
        String newInputedString = reader.readLine();
        field.set(originInputedString, newInputedString.toCharArray());
        System.out.println(originInputedString);
    }
}
