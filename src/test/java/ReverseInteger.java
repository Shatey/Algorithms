import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseInteger {
    @Test
    void test() {
        int s = 123;
        assertEquals(321, reverse(s));
        s = -321;
        assertEquals(-123, reverse(s));
        s = 1534236469;
        assertEquals(0, reverse(s));
    }

    public int reverse(int x) {
        int res = 0;
        int min = Integer.MIN_VALUE / 10;
        int max = Integer.MAX_VALUE / 10;
        while (x != 0) {
            if (res > max || res < min) {
                return 0;
            }
            int num = x % 10;
            res = res * 10 + num;
            x /= 10;
        }
        return res;
    }
}
