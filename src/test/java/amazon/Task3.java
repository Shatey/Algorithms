package amazon;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Task3 {

    @Test
    void test() {

//        System.out.println(findPasswordStrength("code"));
    }
    public static long findPasswordStrength(String password) {
        int count  = password.length();
        for (int i = 1; i < password.length(); i++) {
            int tempIValue = i;
            for (int j = 0; j < i; j++) {
                if(i == password.length()) {
                    i = tempIValue;
                    break;
                }
                Set<Character> chararr = new HashSet<Character>();
                String subStringValue = password.substring(j, i+1);
                for (Character character : subStringValue.toCharArray()) {
                    if(!chararr.contains(character)) {
                        chararr.add(character);
                        count++;
                    }
                }
                i++;
            }
        }

        return count;
    }


}
