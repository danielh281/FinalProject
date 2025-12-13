import org.dh.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepartmentTest {
    @Test
    @DisplayName("isDepartmentNameValid: Computer Science -> true")
    void isDepartmentNameValidTest1() {
        String input = "Computer Science";
        boolean expected = true;
        boolean result = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("isDepartmentNameValid: Mathematics1 -> false")
    void isDepartmentNameValidTest2() {
        String input = "Mathematics1";
        boolean expected = false;
        boolean result = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("isDepartmentNameValid: Computer Science & Mathematics -> false")
    void isDepartmentNameValidTest3() {
        String input = "Computer Science & Mathematics";
        boolean expected = false;
        boolean result = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("isDepartmentNameValid: null -> false")
    void isDepartmentNameValidTest4() {
        String input = null;
        boolean expected = false;
        boolean result = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, result);
    }
}
