import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumber {
    @Test
    void test() {
        assertEquals(0,fib(0));
        assertEquals(1,fib(2));
        assertEquals(2,fib(3));
        assertEquals(3,fib(4));
    }
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        n = n-2;
        var prev = 0;
        var next = 1;
        for (;n >= 0; n--) {
            var tmp = next;
            next += prev;
            prev = tmp;
        }
        return next;
    }
}
