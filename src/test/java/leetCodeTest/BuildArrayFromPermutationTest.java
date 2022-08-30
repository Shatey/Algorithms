package leetCodeTest;

import leetCode.BuildArrayFromPermutation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BuildArrayFromPermutationTest {
    @Test
    void test() {

        assertArrayEquals(new int[]{0, 1, 2, 4, 5, 3}, BuildArrayFromPermutation.buildArray(new int[]{0, 2, 1, 5, 3, 4}));
        assertArrayEquals(new int[]{4, 5, 0, 1, 2, 3}, BuildArrayFromPermutation.buildArray(new int[]{5, 0, 1, 2, 3, 4}));
    }
}
