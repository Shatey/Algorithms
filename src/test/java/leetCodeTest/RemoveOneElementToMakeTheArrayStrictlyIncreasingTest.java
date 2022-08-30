package leetCodeTest;

import leetCode.RemoveOneElementToMakeTheArrayStrictlyIncreasing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasingTest {

    @Test
    void test() {
        assertTrue(RemoveOneElementToMakeTheArrayStrictlyIncreasing.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        assertFalse(RemoveOneElementToMakeTheArrayStrictlyIncreasing.canBeIncreasing(new int[]{2, 3, 1, 2}));
        assertFalse(RemoveOneElementToMakeTheArrayStrictlyIncreasing.canBeIncreasing(new int[]{1, 1, 1}));
        assertTrue(RemoveOneElementToMakeTheArrayStrictlyIncreasing.canBeIncreasing(new int[]{1, 1}));
        assertTrue(RemoveOneElementToMakeTheArrayStrictlyIncreasing.canBeIncreasing(new int[]{105, 924, 32, 968}));
        assertFalse(RemoveOneElementToMakeTheArrayStrictlyIncreasing.canBeIncreasing(new int[]{541, 783, 433, 744}));
    }
}
