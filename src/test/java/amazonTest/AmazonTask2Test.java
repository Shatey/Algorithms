package amazonTest;

import amazon.AmazonTask2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonTask2Test {

    @Test
    void test() {
        Assertions.assertEquals(7, AmazonTask2.maximumQuality(List.of(2, 2, 1, 5, 3), 2));
    }

}
