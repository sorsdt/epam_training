package ua.epam.training.task2.exercise1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    String string;

    public Parser(String string) {
        this.string = string;
    }

    String removeComments() {
        Pattern pattern = Pattern.compile("(\\/\\/.*)|(/\\*(.|[\\r\\n])*?\\*/)");
        Matcher matcher = pattern.matcher(string);
        return matcher.replaceAll("\r\n");
    }
}
