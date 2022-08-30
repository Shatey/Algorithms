package leetCode;

public class RunningSumOf1dArray {
//    https://leetcode.com/problems/running-sum-of-1d-array/

    public static int[] runningSum(int[] nums) {
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
