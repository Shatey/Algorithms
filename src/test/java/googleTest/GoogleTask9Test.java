package googleTest;

import google.GoogleTask9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTask9Test {

    @Test
    void test() {
        boolean[][] g = {{true, false, true},
                {false, true, false},
                {true, false, true}};
        Assertions.assertEquals(4, GoogleTask9.solution(g));
        g = new boolean[][]{{true, true, false, true, false, true, false, true, true, false},
                {true, true, false, false, false, false, true, true, true, false},
                {true, true, false, false, false, false, false, false, false, true},
                {false, true, false, false, false, false, true, true, false, false}};
        assertEquals(11567, GoogleTask9.solution(g));
        g = new boolean[][]{{true, false, true, false, false, true, true, true},
                {true, false, true, false, false, false, true, false},
                {true, true, true, false, false, false, true, false},
                {true, false, true, false, false, false, true, false},
                {true, false, true, false, false, true, true, true}};
        assertEquals(254, GoogleTask9.solution(g));
    }
}
