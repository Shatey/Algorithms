import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSum {
    @Test
    void test() {
        assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{3, 3}, 6));
        assertArrayEquals(new int[]{5, 11}, twoSum(new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1}, 11));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var iVal = nums[i];
            if (map.containsKey(iVal) && map.get(iVal) == i) {
                continue;
            }
            int dif = target - iVal;
            if (map.containsKey(dif)) {
                return new int[]{map.get(dif), i};
            }
            map.put(iVal, i);
        }
        return null;
    }
}
