package leetCodeTest;

import leetCode.ImplementStrStr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementStrStrTest {
    @Test
    void test() {
        assertEquals(2, ImplementStrStr.strStr("hello", "ll"));
        assertEquals(-1, ImplementStrStr.strStr("aaaaa", "bba"));
        assertEquals(2, ImplementStrStr.strStr("abc", "c"));
        assertEquals(4, ImplementStrStr.strStr("mississippi", "issip"));
        assertEquals(1, ImplementStrStr.strStr("mississippi", "issi"));
        assertEquals(-1, ImplementStrStr.strStr("mississippi", "issipi"));
    }
}
