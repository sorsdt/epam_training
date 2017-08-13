package ua.epam.training.ua.epam.training.task4.exercise2_2;

import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Animal.class;
        Constructor<?> constructor = clazz.getConstructor(byte.class, short.class, int.class, int.class);
        Animal animal = (Animal) constructor.newInstance((byte) 4, (short) 10, 20, 30);
        printFields(animal);
        System.out.println("-----");
        invokeMethod(animal, (short) 100);
        printFields(animal);
    }

    private static void printFields(Object o) throws IllegalAccessException {
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            printFieldInfo(o, field);
        }
    }

    private static void printFieldInfo(Object o, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        final int modifiers = field.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.print("public");
        } else {
            if (Modifier.isProtected(modifiers)) {
                System.out.print("protected");
            } else if (Modifier.isPrivate(modifiers)) {
                System.out.print("private");
            } else {
                System.out.print("default");
            }
        }
        System.out.print("|");
        if (Modifier.isStatic(modifiers)) {
            System.out.print("static");
        } else {
            System.out.print("non-static");
        }
        System.out.print("|");
        if (Modifier.isFinal(modifiers)) {
            System.out.print("final");
        } else {
            System.out.print("non-final");
        }
        System.out.print("|");
        System.out.print(field.getType());
        System.out.print("|");
        System.out.print(field.getName());
        System.out.print("|");
        System.out.println(field.get(o));
    }

    private static void invokeMethod(Object o, short age) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<?> clazz = o.getClass();
        Method method = clazz.getMethod("setAge", short.class);
        method.invoke(o, age);
    }
}
