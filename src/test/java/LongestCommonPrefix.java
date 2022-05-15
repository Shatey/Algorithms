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
        String res = strs[0];
        var add = true;
        var charPos = 0;
        var minLen = getMinLen(strs);
        while (add && charPos < minLen) {
            for (var str: strs) {
                add = res.charAt(charPos) == str.charAt(charPos);
                if (!add) {
                    charPos--;
                    break;
                }
            }
            charPos++;
        }
        res = res.substring(0, charPos);
        return res;
    }

    private int getMinLen(String[] strs) {
        var minLen = strs[0].length();
        for (var i = 1; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        return minLen;
    }

    public String longestCommonPrefixp(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String res = null;
        for (var str : strs) {
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
