package ua.epam.training.ua.epam.training.task4.exercise2_2;

public class Animal {
    final byte paws;
    public short age;
    protected int speed;
    private int weight;
    static int count;

    public Animal(byte paws) {
        this.paws = paws;
        count++;
    }

    public Animal(byte paws, short age) {
        this(paws);
        this.age = age;
    }

    public Animal(byte paws, short age, int speed) {
        this(paws, age);
        this.speed = speed;
    }

    public Animal(byte paws, short age, int speed, int weight) {
        this(paws, age, speed);
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public byte getPaws() {
        return paws;
    }
}