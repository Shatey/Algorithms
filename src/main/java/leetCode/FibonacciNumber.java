package leetCode;

public class FibonacciNumber {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        n = n - 2;
        var prev = 0;
        var next = 1;
        for (; n >= 0; n--) {
            var tmp = next;
            next += prev;
            prev = tmp;
        }
        return next;
    }
}
