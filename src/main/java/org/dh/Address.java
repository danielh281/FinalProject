package org.dh;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Address {
    @Setter private int streetNo;
    @Setter private String street;
    @Setter private String city;
    @Setter private Province province;
    private String postalCode;

    /**
     * Checks if a postal code is valid with the following rules:
     * The length can only be 6 characters, and the postal code
     * must follow the CDCDCD format, where C is a character and
     * D is a digit.
     * @param postalCode The postal code to check
     * @return True if the postal code is valid. False if it is not valid
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode.length() != 6) {
            return false;
        }

        char[] characters = postalCode.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (i % 2 != 0 && !Character.isLetter(characters[i])) {
                return false;
            } else if (i % 2 == 0 & !Character.isDigit(characters[i])) {
                return false;
            }
        }

        return true;
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        this.streetNo = streetNo;
        this.street = street;
        this.province = province;
        this.postalCode = (isPostalCodeValid(postalCode)) ? postalCode.toUpperCase() : null;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = (isPostalCodeValid(postalCode)) ? postalCode.toUpperCase() : this.postalCode;
    }

    public enum Province {
        AB, MB, ON, QC, SK, BC, NB, NS, PE, NL
    }
}
