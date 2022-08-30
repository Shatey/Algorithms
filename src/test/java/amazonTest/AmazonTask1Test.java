package amazonTest;

import amazon.AmazonTask1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonTask1Test {
    @Test
    void test1() {
        Assertions.assertEquals(List.of(0, 1, 0, 0, 1, 0, 1, 0), AmazonTask1.cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1));
        assertEquals(List.of(0, 0, 0, 0, 0, 1, 1, 0), AmazonTask1.cellCompete(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2));
    }

    @Test
    void test2() {
        assertEquals(2, AmazonTask1.generalizedGCD(5, new int[]{2,4,6,8,10}));
    }
}
