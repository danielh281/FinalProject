package util;

public class Util {
    /**
     * Converts each word in a stringe to TitleCase.
     * This method assumes that the words in the string
     * are always separated by space.
     * @param str The string to convert to TitleCase
     * @return The string converted to TitleCase
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String str2 = "";

        for (int i = 0; i < words.length; i ++) {
            str2 += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();

            if (i != words.length - 1) {
                str2 += " ";
            }
        }

        return str2;
    }
}
