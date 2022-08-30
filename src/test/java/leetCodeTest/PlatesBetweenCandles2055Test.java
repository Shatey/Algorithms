package leetCodeTest;

import leetCode.PlatesBetweenCandles2055;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlatesBetweenCandles2055Test {

    @Test
    void test() {
        assertArrayEquals(new int[]{2,3}, PlatesBetweenCandles2055.platesBetweenCandles("**|**|***|",  new int[][]{{2,5},{5,9}}));
        assertArrayEquals(new int[]{9,0,0,0,0}, PlatesBetweenCandles2055.platesBetweenCandles("***|**|*****|**||**|*",  new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}}));
    }
}
