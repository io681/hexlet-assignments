package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {

        return Arrays.stream(image)
                .flatMap(x -> Arrays.stream(x)
                                .map(rowStrImage -> rowStrImage + rowStrImage)
                        )
                .map(rowStrImage -> rowStrImage.split(""))
                .toArray(String[][]::new);
    }
}
// END
