package leetCodeTest;

import leetCode.StringToIntegerAtoi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToIntegerAtoiTest {
    @Test
    void test() {
        assertEquals(42, StringToIntegerAtoi.myAtoi("42"));
        assertEquals(-42, StringToIntegerAtoi.myAtoi("   -42"));
        assertEquals(4193, StringToIntegerAtoi.myAtoi("4193 with words"));
        assertEquals(-2147483648, StringToIntegerAtoi.myAtoi("-91283472332"));
        assertEquals(1, StringToIntegerAtoi.myAtoi("+1"));
    }
}