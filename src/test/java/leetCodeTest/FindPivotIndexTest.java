package leetCodeTest;

import leetCode.FindPivotIndex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPivotIndexTest {

    @Test
    void test() {
        assertEquals(3,FindPivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(-1,FindPivotIndex.pivotIndex(new int[]{1, 2, 3}));
        assertEquals(0,FindPivotIndex.pivotIndex(new int[]{2, 1, -1}));
        assertEquals(2,FindPivotIndex.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
        assertEquals(4,FindPivotIndex.pivotIndex(new int[]{-1, -1, 1, 1, 0, 0}));
        assertEquals(0,FindPivotIndex.pivotIndex(new int[]{0}));
    }
}
