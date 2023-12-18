package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static  List<String> buildApartmentsList(List<Home> listHomes, int head) {
        return listHomes.stream()
                .sorted(Home::compareTo)
                .limit(head)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
// END
