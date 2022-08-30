package leetCodeTest;

import leetCode.IsomorphicStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsomorphicStringsTest {

    @Test
    void test() {
        assertTrue(IsomorphicStrings.isIsomorphic("egg", "add"));
        assertFalse(IsomorphicStrings.isIsomorphic("foo", "bar"));
        assertTrue(IsomorphicStrings.isIsomorphic("paper", "title"));
        assertFalse(IsomorphicStrings.isIsomorphic("badc", "baba"));
        assertFalse(IsomorphicStrings.isIsomorphic("abcdefghijklmnopqrstuvwxyzva",
                "abcdefghijklmnopqrstuvwxyzck"));
    }
}
