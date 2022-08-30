package leetCode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !isNumAlphanumeric(s.charAt(i))) {
                i++;
            }
            while ((i < j) && (!isNumAlphanumeric(s.charAt(j)))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumAlphanumeric(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z');
    }
}
