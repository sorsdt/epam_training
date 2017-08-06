package ua.epam.training.task2.exercise1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите текст (Ctrl+D для окончания ввода):");
        int length;
        byte[] buffer = new byte[128];
        StringBuilder stringBuilder = new StringBuilder("");
        while (true) {
            length = System.in.read(buffer);
            if (length < 0) break;
            stringBuilder.append(new String(buffer, 0, length));
        }
        Parser parser = new Parser(stringBuilder.toString());
        System.out.println(parser.removeComments());
    }
}
