import org.dh.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {
    @Test
    @DisplayName("toTitleCase: DISCRETE MATH -> Discrete Math")
    void toTitleCaseTest1() {
        String input = "DISCRETE MATH";
        String expected = "Discrete Math";
        String result = Util.toTitleCase(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("toTitleCase: computer sciencE and mAth -> Computer Science And Math")
    void toTitleCaseTest2() {
        String input = "computer sciencE and mAth";
        String expected = "Computer Science And Math";
        String result = Util.toTitleCase(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("toTitleCase: null -> null")
    void toTitleCaseTest3() {
        String input = null;
        String expected = null;
        String result = Util.toTitleCase(input);

        Assertions.assertEquals(expected, result);
    }
}
