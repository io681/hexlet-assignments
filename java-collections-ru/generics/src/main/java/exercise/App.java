package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static <T1, T2> List<Map<T1, T2>> findWhere(List<Map<T1, T2>> books, Map<T1, T2> whereElement) {
        List<Map<T1, T2>> listResult = new ArrayList<>();

        for (Map<T1, T2> book : books) {
            boolean equalValue = false;
            for (Map.Entry<T1, T2> whereEntry : whereElement.entrySet()) {
                equalValue = book.get(whereEntry.getKey()).equals(whereEntry.getValue());
                if (!equalValue) {
                    break;
                }
            }
            if (equalValue) {
                listResult.add(book);
            }
        }
        return listResult;

    }
}

//END
