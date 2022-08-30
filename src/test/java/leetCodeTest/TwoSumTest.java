package leetCodeTest;

import leetCode.TwoSum;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    @Test
    void test() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum(new int[]{3, 3}, 6));
        assertArrayEquals(new int[]{5, 11}, TwoSum.twoSum(new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1}, 11));
    }
}
