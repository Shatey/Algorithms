package googleTest;

import google.GoogleTask3;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GoogleTask3Test {
    @Test
    void test() {
        var s = GoogleTask3.solution(new String[]{"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"});
        assertArrayEquals(s, new String[]{"1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"});
        s = GoogleTask3.solution(new String[]{"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"});
        assertArrayEquals(s, new String[]{"0.1", "1.1.1", "1.2", "1.2.1", "1.11", "2", "2.0", "2.0.0"});
        s = GoogleTask3.solution(new String[]{"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"});
        assertArrayEquals(s, new String[]{"1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"});
    }
}
