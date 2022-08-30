package google.fromRoma;

public class Task1 {

    /*
     * The cake is not a lie!
     * ======================
     *
     * Commander Lambda has had an incredibly successful week: the first test of the LAMBCHOP doomsday device was
     * completed AND Lambda set a new personal high score in Tetris. To celebrate, the Commander ordered cake for
     * everyone -- even the lowliest of minions! But competition among minions is fierce, and if you don't cut
     * exactly equal slices of cake for everyone you'll get in big trouble.
     *
     * The cake is round, and decorated with M&Ms in a circle around the edge. But while the rest of the cake is
     * uniform, the M&Ms are not: there are multiple colors, and every minion must get exactly the same sequence
     * of M&Ms. Commander Lambda hates waste and will not tolerate any leftovers, so you also want to make sure
     * you can serve the entire cake.
     *
     * To help you best cut the cake, you have turned the sequence of colors of the M&Ms on the cake into a string:
     * each possible letter (between a and z) corresponds to a unique color, and the sequence of M&Ms is given
     * clockwise (the decorations form a circle around the outer edge of the cake).
     *
     * Write a function called solution(s) that, given a non-empty string less than 200 characters in length
     * describing the sequence of M&Ms, returns the maximum number of equal parts that can be cut from the
     * cake without leaving any leftovers.
     *
     * -- Java cases --
     * Input:
     * Solution.solution("abcabcabcabc")
     * Output:
     *     4
     *
     * Input:
     * Solution.solution("abccbaabccba")
     * Output:
     *     2
     */

    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc"));
        System.out.println(solution("abccbaabccba"));
        System.out.println(solution("aaaaaaaazaaaaaaaaz"));
        System.out.println(solution("aaa"));
        System.out.println(solution("a"));
        System.out.println(solution(""));
    }

    public static int solution(String x) {
        var start = System.nanoTime();
        var length = x.length();
        switch (length) {
            case 0:
                return 0;
            case 1:
                return 1;
        }
        int res = 0;
        String tmp = "";
        var last = x.charAt(length - 1);
        for (var character : x.toCharArray()) {
            tmp = String.format("%s%s", tmp, character);
            if (character == last && isTargetSequence(x, tmp)) {
                res = length / tmp.length();
                break;
            }
        }
        var end = System.nanoTime();
        System.out.println(end - start);
        return res;
    }

    private static boolean isTargetSequence(String x, String tmp) {
        boolean res = true;
        var tmpLength = tmp.length();
        var xLength = x.length();
        if (xLength % tmpLength == 0) {
            for (int i = tmpLength, j = tmpLength * 2; j < xLength; i += tmpLength, j += tmpLength)
                if (!tmp.equals(x.substring(i, j))) {
                    res = false;
                    break;
                }
        } else {
            res = false;
        }
        return res;
    }
}
