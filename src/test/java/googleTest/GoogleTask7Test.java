package googleTest;

import google.GoogleTask7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTask7Test {

    @Test
    void test() {
        assertEquals(2, GoogleTask7.solution(new int[]{1, 1}));
        assertEquals(0, GoogleTask7.solution(new int[]{1, 7, 3, 21, 13, 19}));
    }
}
