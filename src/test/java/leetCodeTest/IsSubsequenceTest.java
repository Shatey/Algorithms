package leetCodeTest;

import leetCode.IsSubsequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsSubsequenceTest {

    @Test
    void test() {
        assertTrue(IsSubsequence.isSubsequence("abc", "ahbgdc"));
        assertFalse(IsSubsequence.isSubsequence("axc", "ahbgdc"));
        assertFalse(IsSubsequence.isSubsequence("aaaaaa", "bbaaaa"));
    }
}
