package leetCode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    //https://leetcode.com/problems/isomorphic-strings/

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        var sArr = s.toCharArray();
        var tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            var tChar = tArr[i];
            var sChar = sArr[i];
            if (map.containsKey(sChar) && map.get(sChar) != tChar
                    || !map.containsKey(sChar) && map.containsValue(tChar))
                return false;
            map.put(sArr[i], tArr[i]);
        }
        return true;
    }
}
