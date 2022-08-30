package brightDataTasks;

import java.util.ArrayList;
import java.util.List;

public class BrightDataTasks {

    /*
    Requirements
- Assume the language standard is Java 8
- We expect good performance.
- If missing requirements details, make reasonable assumptions
- Solution must be simple and compact
  - No defensive coding, no comments, no unrequested features.
  - Only one file 10-20 lines of code
- Work only inside Google Docs: no external editor/IDE/debugger, no copy-paste
  to/from such an editor. We must see the flow of how you write the code.

Note: you have a total of 30 minutes for both questions!
Ensure you have filled all pages.
Task 1
Implement function

int verify(String text)

which verifies whether parentheses within text are
correctly nested. You need to consider three kinds: (), [], <> and only these kinds.
Examples
verify("---(++++)----") -> 1
verify("") -> 1
verify("before ( middle []) after ") -> 1
verify(") (") -> 0
verify("<(   >)") -> 0
verify("(  [  <>  ()  ]  <>  )") -> 1
verify("   (      [)") -> 0
     */

    /*
    Task 2
Simplify the implementation below as much as you can.
Even better if you can also improve performance as part of the simplification!
FYI: This code is over 35 lines and over 300 tokens, but it can be written in
5 lines and in less than 60 tokens.
Code
import java.util.regex.*;
public static int func(String s, String a, String b){
    boolean bo = Pattern.matches("^$", s);
    if (bo)
        return -1;
    else
    {
        int i = s.length() - 1;
        int aIndex =- 1;
        int bIndex =- 1;
        while ((aIndex==-1) && (bIndex==-1) && (i>=0))
        {
            if (s.substring(i, i+1).equals(a))
                aIndex=i;
            if (s.substring(i, i+1).equals(b))
                bIndex=i;
            i--;
        }
        if (aIndex != -1)
        {
            if (bIndex == -1)
                return aIndex;
            else
                return Math.max(aIndex, bIndex);
        }
        else
        {
            if (bIndex != -1)
                return bIndex;
    	else
                return -1;
        }
    }
};

     */

    public static int verify(String text) {
        if (text == null || text.isBlank())
            return 1;
        List<Character> tmp = new ArrayList<>();
        for (char character : text.toCharArray()) {
            switch (character) {
                case '(':
                    tmp.add('(');
                    break;
                case '[':
                    tmp.add('[');
                    break;
                case '<':
                    tmp.add('<');
                    break;
                case ')':
                    if (!tmp.isEmpty() && tmp.get(tmp.size() - 1) == '(')
                        tmp.remove(tmp.size() - 1);
                    else
                        return 0;
                    break;
                case ']':
                    if (!tmp.isEmpty() && tmp.get(tmp.size() - 1) == '[')
                        tmp.remove(tmp.size() - 1);
                    else
                        return 0;
                    break;
                case '>':
                    if (!tmp.isEmpty() && tmp.get(tmp.size() - 1) == '<')
                        tmp.remove(tmp.size() - 1);
                    else
                        return 0;
                    break;
            }
        }
        return tmp.size() == 0 ? 1 : 0;
    }

    public static int func(String s, String a, String b) {
        if (s == null || s.isBlank())
            return -1;
        int aIndex = a == null || a.isBlank() ? -1 : s.indexOf(a);
        int bIndex = b == null || b.isBlank() ? -1 : s.indexOf(b);
        return Math.max(aIndex, bIndex);
    }
}
