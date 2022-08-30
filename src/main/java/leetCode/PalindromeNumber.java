package leetCode;

public class PalindromeNumber {


    public static boolean isPalindrome(int x) {
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
