package leetCodeTest;

import leetCode.LongestCommonPrefix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LongestCommonPrefixTest {

    @Test
    void test() {
        String[] first = {"flower", "flow", "flight"};
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(first));
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefixp(first));
        String[] second = {"dog", "racecar", "car"};
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(second));
        assertEquals("", LongestCommonPrefix.longestCommonPrefixp(second));
        String[] third = {"ab", "a"};
        assertEquals("a", LongestCommonPrefix.longestCommonPrefix(third));
        assertEquals("a", LongestCommonPrefix.longestCommonPrefixp(third));
        String[] fourth = {"reflower", "flow", "flight"};
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(fourth));
        assertEquals("", LongestCommonPrefix.longestCommonPrefixp(fourth));
    }
}
