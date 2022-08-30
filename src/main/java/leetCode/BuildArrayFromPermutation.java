package leetCode;

public class BuildArrayFromPermutation {

    public static int[] buildArray(int[] nums) {
        var ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
