import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RunningSumOf1dArray {

//    https://leetcode.com/problems/running-sum-of-1d-array/

    @Test
    void test() {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(runningSum(new int[]{3, 1, 2, 10, 1})));
    }

    public int[] runningSum(int[] nums) {
        var res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = nums[i];
                continue;
            }
            res[i] = nums[i] + res[i - 1];
        }
        return res;
    }
}
