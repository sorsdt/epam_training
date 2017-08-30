package ua.epam.training.task5.exercise2_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите каталог поиска:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String directoryPath = reader.readLine();
        System.out.println("Введите файл для сохранения:");
        String filePath = reader.readLine();
//        directoryPath = "F:\\downloads\\";
//        filePath = "F:\\downloads\\test.txt";
        File dir = new File(directoryPath);
        Saver.setFilePath(filePath);
        if (dir.isDirectory()) {
            Parser.parseDir(dir);
        } else {
            System.out.println(directoryPath + " is not a directory");
        }
    }
}