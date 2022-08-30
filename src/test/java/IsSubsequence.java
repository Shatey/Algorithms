import org.junit.jupiter.api.Test;

public class IsSubsequence {

//    https://leetcode.com/problems/is-subsequence/

    @Test
    void test() {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        short length = (short) s.length();
        short tLength = (short) t.length();
        short sLength = (short) s.length();
        for (int i = 0, j = 0; i < sLength && j < tLength && length <= tLength - j; ) {
            var sChar = s.charAt(i);
            var tChar = t.charAt(j++);
            if (sChar == tChar) {
                length--;
                i++;
            }
        }
        return length == 0;
    }
}
