package exercise;

import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String>  currentMap = storage.toMap();
        for (var entry : currentMap.entrySet()) {
            var currentKey = entry.getKey();
            var currentValue = entry.getValue();
            storage.unset(currentKey);
            storage.set(currentValue, currentKey);
        }
    }
}
// END
