package ua.epam.training.task2.exercise2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    String string;
    String regexp;

    public Parser(String string, String regexp) {
        this.string = string;
        this.regexp = regexp;
    }

    void printResults() {
        boolean noResults = true;
        Pattern pattern = Pattern.compile(regexp);
        String[] strings = string.split("\\s");
        for (String splitedString : strings) {
            Matcher matcher = pattern.matcher(splitedString);
            while (matcher.find()) {
                noResults = false;
                System.out.println(matcher.group());
            }
        }
        if (noResults) {
            System.out.println("По данному запросу совпадения отсутствуют");
        }
    }
}
