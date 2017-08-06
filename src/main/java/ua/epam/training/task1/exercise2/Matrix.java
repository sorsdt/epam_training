package ua.epam.training.task1.exercise2;

public class Matrix {
    byte[][] matrix;

    public Matrix(final int size) {
        matrix = new byte[size][size];
    }

    void fillByRandom() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (byte) (Math.random() * 256 - 128);
            }
        }
    }

    void printMatrix() {
        int maxElementLength = getMaxElementLength();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String st = String.valueOf(matrix[i][j]);
                for (int k = 0; k <= maxElementLength - st.length(); k++) {
                    System.out.print(" ");
                }
                System.out.print(st);
            }
            System.out.println();
        }
    }

    private int getMaxElementLength() {
        int maxElementLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                maxElementLength = Math.max(String.valueOf(matrix[i][j]).length(), maxElementLength);
            }
        }
        return maxElementLength;
    }

    void shiftUP() {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (byte) (matrix[i][j] + matrix[i + 1][j]);
                matrix[i + 1][j] = (byte) (matrix[i + 1][j] - matrix[i][j]);
                matrix[i + 1][j] = (byte) -matrix[i + 1][j];
                matrix[i][j] = (byte) (matrix[i][j] - matrix[i + 1][j]);
            }
        }
    }

    void shiftUP(int shiftsCount) {
        for (int i = 0; i < shiftsCount; i++) {
            this.shiftUP();
        }
    }
}
