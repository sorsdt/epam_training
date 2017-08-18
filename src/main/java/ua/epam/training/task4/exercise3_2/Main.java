package ua.epam.training.task4.exercise3_2;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        translator.addEnRuPair("a", "");
        translator.addEnRuPair("an", "");
        translator.addEnRuPair("the", "");
        translator.addEnRuPair("and", "и");
        translator.addEnRuPair("i", "я");
        translator.addEnRuPair("have", "иметь");
        translator.addEnRuPair("dog", "собака");
        translator.addEnRuPair("pig", "поросёнок");
        translator.addEnRuPair("frog", "лягушка");
        String origin_sentence = "I have a Dog, a pig and a frog.";
        String translated_sentence = translator.translateEnRuSentence(origin_sentence);
        System.out.println(translated_sentence);
    }
}
