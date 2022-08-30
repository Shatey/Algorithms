package leetCodeTest;

import leetCode.ReverseInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseIntegerTest {
    @Test
    void test() {
        int s = 123;
        assertEquals(321, ReverseInteger.reverse(s));
        s = -321;
        assertEquals(-123, ReverseInteger.reverse(s));
        s = 1534236469;
        assertEquals(0, ReverseInteger.reverse(s));
    }
}
