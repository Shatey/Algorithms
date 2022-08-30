package brightDataTasksTest;

import brightDataTasks.BrightDataTasks;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrightDataTasksTest {

    @Test
    void task1() {
        assertEquals(1, BrightDataTasks.verify("---(++++)----"));
        assertEquals(1, BrightDataTasks.verify(""));
        assertEquals(1, BrightDataTasks.verify("before ( middle []) after "));
        assertEquals(0, BrightDataTasks.verify(") ("));
        assertEquals(0, BrightDataTasks.verify("<(   >)"));
        assertEquals(1, BrightDataTasks.verify("(  [  <>  ()  ]  <>  )"));
        assertEquals(0, BrightDataTasks.verify("   (      [)"));
        assertEquals(0, BrightDataTasks.verify(")"));
    }

    @Test
    void task2() {
        assertEquals(2, BrightDataTasks.func("qwe", "e", "qwe"));
        assertEquals(1, BrightDataTasks.func("qwe", "r", "w"));
        assertEquals(-1, BrightDataTasks.func("1", "", "q"));
    }
}
