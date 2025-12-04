package org.dh;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

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

    public enum Province {
        AB, MB, ON, QC, SK, BC, NB, NS, PE, NL
    }
}
