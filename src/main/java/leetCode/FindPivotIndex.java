package leetCode;

public class FindPivotIndex {
//    https://leetcode.com/problems/find-pivot-index/

    public static int pivotIndex(int[] nums) {
        var res = -1;
        if (nums.length > 0) {
            var leftSum = 0;
            var rightSum = 0;
            for (var num : nums) {
                rightSum += num;
            }
            for (int i = 0; i < nums.length; i++) {
                rightSum -= nums[i];
                if (rightSum == leftSum) {
                    res = i;
                    break;
                }
                leftSum += nums[i];
            }
        }
        return res;
    }
}
