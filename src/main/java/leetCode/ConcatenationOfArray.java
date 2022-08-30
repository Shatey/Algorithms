package leetCode;

public class ConcatenationOfArray {

    public static int[] getConcatenation(int[] nums) {
        var len = nums.length;
        var res = new int[len * 2];
        for (int i = 0; i < len; i++) {
            res[i] = res[i + len] = nums[i];
        }
        return res;
    }
}
