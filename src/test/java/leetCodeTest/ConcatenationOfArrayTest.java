package leetCodeTest;

import leetCode.ConcatenationOfArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ConcatenationOfArrayTest {
    @Test
    void test() {
        assertArrayEquals(new int[]{1, 2, 1, 1, 2, 1}, ConcatenationOfArray.getConcatenation(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{1, 3, 2, 1, 1, 3, 2, 1}, ConcatenationOfArray.getConcatenation(new int[]{1, 3, 2, 1}));
    }
}
