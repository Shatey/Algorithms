package leetCode;

public class FirstUniqueCharacterAnAString {

    public static int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;
        int left;
        for (char c = 'a'; c <= 'z'; c++) {
            left = s.indexOf(c);
            if (left != -1 && left == s.lastIndexOf(c)) {
                res = Math.min(left, res);
            }

        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
