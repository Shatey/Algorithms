import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementStrStr {
    @Test
    void test() {
        assertEquals(2, strStr("hello", "ll"));
        assertEquals(-1, strStr("aaaaa", "bba"));
        assertEquals(2, strStr("abc", "c"));
        assertEquals(4, strStr("mississippi","issip"));
        assertEquals(1, strStr("mississippi","issi"));
        assertEquals(-1, strStr("mississippi","issipi"));
    }

    public int strStr(String haystack, String needle) {
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
