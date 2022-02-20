import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqueCharacterAnAString {
    @Test
    void test() {
        assertEquals(0, firstUniqChar("leetcode"));
        assertEquals(2, firstUniqChar("loveleetcode"));
        assertEquals(-1, firstUniqChar("aabb"));
    }

    private int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;
        int left;
        for(char c = 'a'; c <= 'z'; c ++ ){
            left = s.indexOf(c);
            if(left != -1 && left == s.lastIndexOf(c)) {
                res = Math.min(left, res);
            }

        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
}
