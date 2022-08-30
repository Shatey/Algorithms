package googleTest;

import google.GoogleTask1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GoogleTask1Test {

    @Test
    void test() {
        assertArrayEquals(new int[]{}, GoogleTask1.solution(new int[]{1, 2, 3}, 0));
        assertArrayEquals(new int[]{5, 15, 7}, GoogleTask1.solution(new int[]{5, 10, 15, 10, 7}, 1));
        assertArrayEquals(new int[]{1, 4}, GoogleTask1.solution(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5}, 1));
        assertArrayEquals(new int[]{}, GoogleTask1.solution(new int[]{}, 1));
    }
}
