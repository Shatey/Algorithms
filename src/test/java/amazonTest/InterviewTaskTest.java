package amazonTest;

import amazon.InterviewTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
        200. Number of Islands
        https://leetcode.com/problems/number-of-islands/
 */
public class InterviewTaskTest {

    @Test
    void test() {
        var arr = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Assertions.assertEquals(1, InterviewTask.numIslands(arr));
        arr = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, InterviewTask.numIslands(arr));
    }
}
