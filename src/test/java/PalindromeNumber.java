import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PalindromeNumber {
    @Test
    void test() {
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(10));

    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        var y = 0;
        var tmp = x;
        while (tmp != 0) {
            var e = y * 10;
            var d = tmp % 10;
            y = e + d;
            tmp = tmp / 10;
            if (tmp / 10 == y) {
                return true;
            }
        }
        return x == y;
    }
}
