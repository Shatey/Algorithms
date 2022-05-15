import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BuildArrayFromPermutation {
    @Test
    void test() {
        assertArrayEquals(new int[]{0, 1, 2, 4, 5, 3}, buildArray(new int[]{0, 2, 1, 5, 3, 4}));
        assertArrayEquals(new int[]{4, 5, 0, 1, 2, 3}, buildArray(new int[]{5, 0, 1, 2, 3, 4}));
    }

    public int[] buildArray(int[] nums) {
        var ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
