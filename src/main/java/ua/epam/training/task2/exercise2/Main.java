package ua.epam.training.task2.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите регулярку:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regexp = reader.readLine();
        System.out.println("Введите текст (Ctrl+D для окончания ввода):");
        int length;
        byte[] buffer = new byte[128];
        StringBuilder stringBuilder = new StringBuilder("");
        while (true) {
            length = System.in.read(buffer);
            if (length < 0) break;
            stringBuilder.append(new String(buffer, 0, length));
        }
        String string = stringBuilder.toString();
//        String string = "+5A- +6b- +7-";
//        String regexp = "^(\\+|-)([5-9])+([5-9]*|[A-G]*)-$";
        Parser parser = new Parser(string, regexp);
        parser.printResults();
    }
}
