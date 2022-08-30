package leetCode;

public class ReverseInteger {

    public static int reverse(int x) {
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
