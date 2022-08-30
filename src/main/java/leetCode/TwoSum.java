package leetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
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
