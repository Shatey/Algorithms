package leetCodeTest;

import leetCode.ValidPalindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindromeTest {
    @Test
    void test() {
        assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(ValidPalindrome.isPalindrome("race a car"));
        assertFalse(ValidPalindrome.isPalindrome("0P"));
    }
}
