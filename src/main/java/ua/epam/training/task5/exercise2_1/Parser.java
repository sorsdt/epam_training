package ua.epam.training.task5.exercise2_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static final String FILE_MASK = ".txt";
//    private static final String FILE_MASK = ".pdf";

    static void parseDir(final File dir) throws IOException {
        File[] files = dir.listFiles();
        for (final File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(FILE_MASK)) {
                    String parseResult;
                    if (!"".equals(parseResult = parseFile(file))) {
                        System.out.println(parseResult);
                        Saver.append(parseResult);
                    }
                }
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            parseDir(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }

    private static String parseFile(final File file) throws IOException {
        int matchesCount = 0;
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    matchesCount++;
                }
            }
        }
        if (matchesCount > 0) {
            return file.getPath() + " " + matchesCount;
        } else {
            return "";
        }
    }
}
