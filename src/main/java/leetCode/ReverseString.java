package leetCode;

public class ReverseString {

    public static char[] reverseString(char[] s) {
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
