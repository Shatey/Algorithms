package googleTest;

import google.GoogleTask2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTask2Test {
    @Test
    void test() {
        assertEquals(4, GoogleTask2.solution("<<>><"));
        assertEquals(2, GoogleTask2.solution(">----<"));
        assertEquals(10, GoogleTask2.solution("--->-><-><-->-"));
    }
}
