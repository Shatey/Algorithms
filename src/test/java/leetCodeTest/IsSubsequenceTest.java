package leetCodeTest;

import leetCode.IsSubsequence;
import org.junit.jupiter.api.Test;

public class IsSubsequenceTest {

    @Test
    void test() {
        System.out.println(IsSubsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(IsSubsequence.isSubsequence("axc", "ahbgdc"));
        System.out.println(IsSubsequence.isSubsequence("aaaaaa", "bbaaaa"));
    }
}
