import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringToIntegerAtoi {
    @Test
    void test() {
        assertEquals(42, myAtoi("42"));
        assertEquals(-42, myAtoi("   -42"));
        assertEquals(4193, myAtoi("4193 with words"));
        assertEquals(-2147483648, myAtoi("-91283472332"));
        assertEquals(1, myAtoi("+1"));
    }

    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }
        if (index < n && input.charAt(index) == '+') {
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = 10 * result + digit;
            index++;
        }
        return sign * result;
    }
}