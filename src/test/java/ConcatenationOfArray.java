import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ConcatenationOfArray {
    @Test
    void test() {
        assertArrayEquals(new int[]{1, 2, 1, 1, 2, 1}, getConcatenation(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{1, 3, 2, 1, 1, 3, 2, 1}, getConcatenation(new int[]{1, 3, 2, 1}));
    }

    public int[] getConcatenation(int[] nums) {
        var len = nums.length;
        var res = new int[len * 2];
        for (int i = 0; i < len; i++) {
            res[i] = res[i + len] = nums[i];
        }
        return res;
    }
}
