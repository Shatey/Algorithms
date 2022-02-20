import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindrome {
    @Test
    void test() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(isPalindrome("race a car"));
        assertFalse(isPalindrome("0P"));
    }

    private boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !isNumAlphanumeric(s.charAt(i))) {
                i++;
            }
            while ((i < j) && (!isNumAlphanumeric(s.charAt(j)))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumAlphanumeric(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z');
    }
}
