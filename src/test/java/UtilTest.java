import org.dh.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {
    @Test
    @DisplayName("toTitleCase: he llo -> He Llo")
    void toTitleCaseTest1() {
        String input = "he llo";
        String expected = "He Llo";
        String result = Util.toTitleCase(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("toTitleCase: null -> null")
    void toTitleCaseTest2() {
        String input = null;
        String expected = null;
        String result = Util.toTitleCase(input);

        Assertions.assertEquals(expected, result);
    }
}
