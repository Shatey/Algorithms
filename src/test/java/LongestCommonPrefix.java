import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LongestCommonPrefix {

    @Test
    void test() {
        String[] first = {"flower", "flow", "flight"};
        assertEquals("fl", longestCommonPrefix(first));
        String[] second = {"dog", "racecar", "car"};
        assertEquals("", longestCommonPrefix(second));
        String[] third = {"ab", "a"};
        assertEquals("a", longestCommonPrefix(third));
        String[] fourth = {"reflower", "flow", "flight"};
        assertEquals("", longestCommonPrefix(fourth));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String res = null;
        for (var str: strs) {
            if (res == null) {
                res = str;
                continue;
            }
            res = res.length() > str.length() ? res.substring(0, str.length()) : res;
            while (!res.equals(str.substring(0, res.length()))) {
                res = res.substring(0, res.length() - 1);
            }
            if (res.isBlank()) {
                break;
            }
        }
        return res;
    }
}
