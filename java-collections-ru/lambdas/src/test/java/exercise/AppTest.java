package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void enlargeArrayImageTest() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

//        String[][] imageExpected = {
//            {"*", "*", "*", "*", "*", "*", "*", "*"},
//            {"*", "*", "*", "*", "*", "*", "*", "*"},
//            {"*", "*", " ", " ", " ", " ", "*", "*"},
//            {"*", "*", " ", " ", " ", " ", "*", "*"},
//            {"*", "*", " ", " ", " ", " ", "*", "*"},
//            {"*", "*", " ", " ", " ", " ", "*", "*"},
//            {"*", "*", "*", "*", "*", "*", "*", "*"},
//            {"*", "*", "*", "*", "*", "*", "*", "*"},
//        };

        String[][] imageExpected = {
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {" ", " "},
                {" ", " "},
                {"*", "*"},
                {"*", "*"},
                {" ", " "},
                {" ", " "},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
        };

        String[][] actualEnlargedImage = App.enlargeArrayImage(image);
        assertThat(actualEnlargedImage).isEqualTo(imageExpected);
    }

    @Test
    void enlargeEmptyArrayImageTest() {
        String[][] image = {};
        String[][] imageExpected = {};
        String[][] actualEnlargedImage = App.enlargeArrayImage(image);

        assertThat(actualEnlargedImage).isEqualTo(imageExpected);

    }
}
// END
