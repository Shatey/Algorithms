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
        assertArrayEquals(new int[]{5,11}, twoSum(new int[]{1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1}, 11));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]) || map.get(target-nums[i]) == -1) {
                map.put(target - nums[i], -1);
                map.put(nums[i], i);
            } else {
                res = new int[]{map.get(target - nums[i]), i};
                break;
            }
        }
        return res;
    }
}
