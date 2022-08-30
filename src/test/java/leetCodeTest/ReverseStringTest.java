package leetCodeTest;

import leetCode.ReverseString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseStringTest {
    @Test
    void test() {
        char[] s = {'h','e','l','l','o'};
        assertArrayEquals(ReverseString.reverseString(s), new char[]{'o', 'l', 'l', 'e', 'h'});
        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, ReverseString.reverseString(s));
    }
}
