package amazonTest;

import amazon.AmazonTask3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmazonTask3Test {

    @Test
    void test() {
        Assertions.assertEquals(20, AmazonTask3.findPasswordStrength("code"));
    }
}
