package leetCode;

public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        if (needle.isBlank() || needle.equals(haystack))
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int res = 0;
        var found = false;
        for (int h = 0, n = 0; h < haystack.length() && n < needle.length();) {
            if (haystack.charAt(h) == needle.charAt(n)) {
                n++;
                h++;
            } else {
                res++;
                n = 0;
                h = res;
            }
            if (n == needle.length()) {
                found = true;
                break;
            }
        }
        return found ? res : -1;
    }
}
