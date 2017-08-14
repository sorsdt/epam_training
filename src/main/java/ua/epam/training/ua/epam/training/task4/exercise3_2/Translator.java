package ua.epam.training.ua.epam.training.task4.exercise3_2;

import java.util.HashMap;
import java.util.Map;

public class Translator {
    private Map<String, String> enRuDictionary = new HashMap<>();

    public void addEnRuPair(String key, String value) {
        enRuDictionary.put(key.toLowerCase(), value.toLowerCase());
    }

    public String translateEnRuSentence(final String sentence) {
        StringBuilder stringBuilder = new StringBuilder("");
        String[] words = sentence.split(" ");
        for (String word : words) {
            char mark = word.charAt(word.length() - 1);
            String translated;
            if ((mark == ',') || (mark == '.')) {
                translated = enRuDictionary.get(word.substring(0, word.length() - 1).toLowerCase());
                if (translated != null) translated += mark;
            } else {
                translated = enRuDictionary.get(word.toLowerCase());
            }
            if (translated == null) {
                stringBuilder.append(word + " ");
            } else {
                if (!"".equals(translated)) stringBuilder.append(translated + " ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
