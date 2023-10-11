package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String text, String targetWord) {
        String textNormalized = text.toLowerCase();
        String targetWordNormalized = targetWord.toLowerCase();

        List<String> listTargetWordSymbols = new LinkedList<>(Arrays.asList(targetWordNormalized.split("")));
        List<String> listSymbolsForScrabble = new ArrayList<>(Arrays.asList(textNormalized.split("")));

        for (int i = 0; i < listTargetWordSymbols.size(); i++) {
            String currentElement = listTargetWordSymbols.get(i);
            if (listSymbolsForScrabble.contains(currentElement)) {
                listSymbolsForScrabble.remove(currentElement);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
