package googleTest;

import google.GoogleTask6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTask6Test {
    @Test
    void test() {
        assertEquals(1, GoogleTask6.solution(new int[]{1, 1, 1}));
        assertEquals(3, GoogleTask6.solution(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
