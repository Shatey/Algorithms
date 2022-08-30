package leetCodeTest;

import leetCode.PalindromeNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PalindromeNumberTest {
    @Test
    void test() {
        assertTrue(PalindromeNumber.isPalindrome(121));
        assertFalse(PalindromeNumber.isPalindrome(-121));
        assertFalse(PalindromeNumber.isPalindrome(10));
    }
}
