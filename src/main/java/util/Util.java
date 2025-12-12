package util;

public class Util {
    public static String toTitleCase(String str) {
        String[] strs = str.split(" ");

        String str1 = strs[0].substring(0, 1).toUpperCase() + strs[0].substring(1);
        String str2 = strs[1].substring(0, 1).toUpperCase() + strs[1].substring(1);

        return str1 + " " + str2;
    }
}
