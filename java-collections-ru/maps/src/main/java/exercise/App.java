package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static String toString(Map<String, Integer> wordCount) {
        if (wordCount.isEmpty()) {
            return "{}";
        }
        String substring = "";

        for (Map.Entry<String, Integer> entry: wordCount.entrySet()) {
            substring += "  " + entry.getKey() + ": " + entry.getValue() + "\n";
        }

        return "{" + "\n" + substring + "}";
    }

    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split(" ");

        if (text.isEmpty()) {
            return wordCount;
        }

        for (String word : words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 1);
            } else {
                int freq = wordCount.get(word);
                freq++;
                wordCount.put(word, freq);
            }
        }

        return wordCount;
    }
}
//END
