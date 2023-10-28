package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
//import java.util.Set;
//import java.util.TreeSet;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static Map<String, String>  genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();

        //added
        data2.keySet().stream()
                .filter(key -> !data1.containsKey(key))
                .forEach(key -> result.put(key, "added"));

        //deleted
        data1.keySet().stream()
                .filter(key -> !data2.containsKey(key))
                .forEach(key -> result.put(key, "deleted"));

        //changed and unchanged
        data1.keySet().stream()
                .filter(key -> data2.containsKey(key))
                .forEach(key -> {
                    if (data1.get(key).equals(data2.get(key))) {
                        result.put(key, "unchanged");
                    } else {
                        result.put(key, "changed");
                    }
                });

        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) ->
                        oldValue, LinkedHashMap::new));
    }
}
//END
