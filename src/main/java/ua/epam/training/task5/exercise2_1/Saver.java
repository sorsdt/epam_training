package ua.epam.training.task5.exercise2_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class Saver {
    private static String filePath;

    public static void setFilePath(String filePath) throws IOException {
        Saver.filePath = filePath;
        Files.deleteIfExists(Paths.get(filePath));
        Files.createFile(Paths.get(filePath));
    }

    synchronized static void append(String content) throws IOException {
        Files.write(Paths.get(Saver.filePath), (content + "\r\n").getBytes(), StandardOpenOption.APPEND);
    }
}
