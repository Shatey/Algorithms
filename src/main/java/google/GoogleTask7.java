package google;

import java.util.Arrays;

public class GoogleTask7 {
    /*
    Distract the Trainers
    =====================

    The time for the mass escape has come, and you need to distract the bunny trainers so that the workers can make it out! Unfortunately for you, they're watching the bunnies closely. Fortunately, this means they haven't realized yet that the space station is about to explode due to the destruction of the LAMBCHOP doomsday device. Also fortunately, all that time you spent working as first a minion and then a henchman means that you know the trainers are fond of bananas. And gambling. And thumb wrestling.

    The bunny trainers, being bored, readily accept your suggestion to play the Banana Games.

    You will set up simultaneous thumb wrestling matches. In each match, two trainers will pair off to thumb wrestle. The trainer with fewer bananas will bet all their bananas, and the other trainer will match the bet. The winner will receive all of the bet bananas. You don't pair off trainers with the same number of bananas (you will see why, shortly). You know enough trainer psychology to know that the one who has more bananas always gets over-confident and loses. Once a match begins, the pair of trainers will continue to thumb wrestle and exchange bananas, until both of them have the same number of bananas. Once that happens, both of them will lose interest and go back to supervising the bunny workers, and you don't want THAT to happen!

    For example, if the two trainers that were paired started with 3 and 5 bananas, after the first round of thumb wrestling they will have 6 and 2 (the one with 3 bananas wins and gets 3 bananas from the loser). After the second round, they will have 4 and 4 (the one with 6 bananas loses 2 bananas). At that point they stop and get back to training bunnies.

    How is all this useful to distract the bunny trainers? Notice that if the trainers had started with 1 and 4 bananas, then they keep thumb wrestling! 1, 4 -> 2, 3 -> 4, 1 -> 3, 2 -> 1, 4 and so on.

    Now your plan is clear. You must pair up the trainers in such a way that the maximum number of trainers go into an infinite thumb wrestling loop!

    Write a function solution(banana_list) which, given a list of positive integers depicting the amount of bananas the each trainer starts with, returns the fewest possible number of bunny trainers that will be left to watch the workers. Element i of the list will be the number of bananas that trainer i (counting from 0) starts with.

    The number of trainers will be at least 1 and not more than 100, and the number of bananas each trainer starts with will be a positive integer no more than 1073741823 (i.e. 2^30 -1). Some of them stockpile a LOT of bananas.

    Languages
    =========

    To provide a Python solution, edit solution.py
    To provide a Java solution, edit expandingNebula.Solution.java

    Test cases
    ==========
    Your code should pass the following test cases.
    Note that it may also be run against hidden test cases not shown here.

    -- Python cases --
    Input:
    solution.solution(1,1)
    Output:
        2

    Input:
    solution.solution([1, 7, 3, 21, 13, 19])
    Output:
        0

    -- Java cases --
    Input:
    solution.solution(1,1)
    Output:
        2

    Input:
    solution([1, 7, 3, 21, 13, 19])
    Output:
        0
     */

    private static int len;
    private static int[][] graph;

    public static int solution(int[] banana_list) {
        len = banana_list.length;
        graph = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                graph[i][j] = deadLock(banana_list[i], banana_list[j]);
                graph[j][i] = graph[i][j];
            }
        }
        return maxPairCount();
    }

    private static int maxPairCount() {
        var matcher = new int[len];
        Arrays.fill(matcher, -1);
        var res = 0;
        for (int i = 0; i < len; i++) {
            var seen = new boolean[len];
            if (bpm(matcher, seen, i)) {
                res++;
            }
        }
        return len - 2 * (res / 2);
    }

    private static boolean bpm(int[] matcher, boolean[] seen, int i) {
        for (int j = 0; j < len; j++) {
            if (graph[i][j] != 0 && !seen[j]) {
                seen[j] = true;
                if (matcher[j] == -1 || bpm(matcher, seen, matcher[j])) {
                    matcher[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

    private static int deadLock(int iVal, int jVal) {
        while (true) {
            if (iVal == jVal) {
                return 0;
            }
            if ((iVal + jVal) % 2 == 1) {
                return 1;
            }
            var GreatestCommonDivisor = getGreatestCommonDivisor(iVal, jVal);
            if (GreatestCommonDivisor > 1) {
                iVal /= GreatestCommonDivisor;
                jVal /= GreatestCommonDivisor;
            }
            var max = Math.max(iVal, jVal);
            var min = Math.min(iVal, jVal);
            iVal = max - min;
            jVal = min * 2;
        }
    }

    private static int getGreatestCommonDivisor(int iVal, int jVal) {
        while (jVal > 0) {
            var tmp = iVal;
            iVal = jVal;
            jVal = tmp % jVal;
        }
        return iVal;
    }
}
