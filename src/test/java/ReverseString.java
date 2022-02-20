import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseString {
    @Test
    void test() {
        char[] s = {'h','e','l','l','o'};
        assertArrayEquals(reverseString(s), new char[]{'o', 'l', 'l', 'e', 'h'});
        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, reverseString(s));
    }

    public char[] reverseString(char[] s) {
        int start  = 0 ;
        int end =  s.length -1 ;

        while( start < end ) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
        return s;
    }
}
