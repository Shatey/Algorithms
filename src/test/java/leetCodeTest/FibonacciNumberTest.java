package leetCodeTest;

import leetCode.FibonacciNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberTest {
    @Test
    void test() {
        assertEquals(0, FibonacciNumber.fib(0));
        assertEquals(1,FibonacciNumber.fib(2));
        assertEquals(2,FibonacciNumber.fib(3));
        assertEquals(3,FibonacciNumber.fib(4));
    }
}
