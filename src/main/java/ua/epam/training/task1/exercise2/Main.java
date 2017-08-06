package ua.epam.training.task1.exercise2;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(6);
        matrix.fillByRandom();
        matrix.printMatrix();
        System.out.println();
        int shiftsCount = (int) (Math.random() * 7);
        System.out.println("Shifts=" + shiftsCount);
        System.out.println();
        matrix.shiftUP(shiftsCount);
        matrix.printMatrix();
    }
}
