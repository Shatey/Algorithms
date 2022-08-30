package leetCodeTest;

import leetCode.FirstUniqueCharacterAnAString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqueCharacterAnAStringTest {
    @Test
    void test() {
        assertEquals(0, FirstUniqueCharacterAnAString.firstUniqChar("leetcode"));
        assertEquals(2, FirstUniqueCharacterAnAString.firstUniqChar("loveleetcode"));
        assertEquals(-1, FirstUniqueCharacterAnAString.firstUniqChar("aabb"));
    }
}
