import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindPivotIndex {
//    https://leetcode.com/problems/find-pivot-index/

    @Test
    void test() {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pivotIndex(new int[]{2, 1, -1}));
        System.out.println(pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
        System.out.println(pivotIndex(new int[]{-1, -1, 1, 1, 0, 0}));
        System.out.println(pivotIndex(new int[]{0}));
    }

    public int pivotIndex(int[] nums) {
        var res = -1;
        if (nums.length > 0) {
            var leftSum = 0;
            var rightSum = 0;
            for (var num: nums) {
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
