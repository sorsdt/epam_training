package ua.epam.training.task1.exercise1_1;

public class Conversions {
    public static void printBinary(short number) {
        printBits(number, 16);
    }

    public static void printBinary(int number) {
        printBits(number, 32);
    }

    public static void printBinary(long number) {
        printBits(number, 64);
    }

    public static void printBits(long number, int quantityOfBits) {
        System.out.print("Binary:\t");
        if (number == 0) {
            System.out.print(0);
        } else {
            boolean showZeros = false;
            for (int i = 0; i < quantityOfBits; i++) {
                if (number < 0) {
                    showZeros = true;
                    System.out.print(1);
                } else {
                    if (showZeros) {
                        System.out.print(0);
                    }
                }
                number <<= 1;
            }
        }
        System.out.println();
    }

    public static void printOctal(long number) {
        System.out.print("Octal:\t");
        final short quantityOfBytes = 22;
        byte[] bytes = new byte[quantityOfBytes];
        short position = quantityOfBytes;
        do {
            bytes[--position] = (byte) (number & 7);
            number >>>= 3;
        } while (number != 0);
        for (int j = position; j < quantityOfBytes; j++) {
            System.out.print(bytes[j]);
        }
        System.out.println();
    }

    public static void printHEX(long number) {
        System.out.printf("HEX:\t%x\n", number);
    }
}
