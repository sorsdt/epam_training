package ua.epam.training.task5.exercise1_3;

public abstract class Resource {
    abstract String read(Integer key);
    abstract void write(Integer key, String value);
}
