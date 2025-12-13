import org.dh.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    @DisplayName("isPostalCodeValid: A1B2C3 -> true")
    void isPostalCodeValidTest1() {
        String input = "A1B2C3";
        boolean expected = true;
        boolean result = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("isPostalCodeValid: A1B2CD -> false")
    void isPostalCodeValidTest2() {
        String input = "A1B2CD";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("isPostalCodeValid: A1B2C3D4 -> false")
    void isPostalCodeValidTest3() {
        String input = "A1B2C3D4";
        boolean expected = false;
        boolean result = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, result);
    }
}
