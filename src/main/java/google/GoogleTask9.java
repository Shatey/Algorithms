package google;

import java.util.*;
import java.util.stream.Collectors;

public class GoogleTask9 {

    /*
        Expanding Nebula
        ================

        You've escaped Commander Lambda's exploding space station along with numerous escape pods full of bunnies. But -- oh no! -- one of the escape pods has flown into a nearby nebula, causing you to lose track of it. You start monitoring the nebula, but unfortunately, just a moment too late to find where the pod went. However, you do find that the gas of the steadily expanding nebula follows a simple pattern, meaning that you should be able to determine the previous state of the gas and narrow down where you might find the pod.

        From the scans of the nebula, you have found that it is very flat and distributed in distinct patches, so you can model it as a 2D grid. You find that the current existence of gas in a cell of the grid is determined exactly by its 4 nearby cells, specifically, (1) that cell, (2) the cell below it, (3) the cell to the right of it, and (4) the cell below and to the right of it. If, in the current state, exactly 1 of those 4 cells in the 2x2 block has gas, then it will also have gas in the next state. Otherwise, the cell will be empty in the next state.

        For example, let's say the previous state of the grid (p) was:
        .O..
        ..O.
        ...O
        O...

        To see how this grid will change to become the current grid (c) over the next time step, consider the 2x2 blocks of cells around each cell.  Of the 2x2 block of [p[0][0], p[0][1], p[1][0], p[1][1]], only p[0][1] has gas in it, which means this 2x2 block would become cell c[0][0] with gas in the next time step:
        .O -> O
        ..

        Likewise, in the next 2x2 block to the right consisting of [p[0][1], p[0][2], p[1][1], p[1][2]], two of the containing cells have gas, so in the next state of the grid, c[0][1] will NOT have gas:
        O. -> .
        .O

        Following this pattern to its conclusion, from the previous state p, the current state of the grid c will be:
        O.O
        .O.
        O.O

        Note that the resulting output will have 1 fewer row and column, since the bottom and rightmost cells do not have a cell below and to the right of them, respectively.

        Write a function solution(g) where g is an array of array of bools saying whether there is gas in each cell (the current scan of the nebula), and return an int with the number of possible previous states that could have resulted in that grid after 1 time step.  For instance, if the function were given the current state c above, it would deduce that the possible previous states were p (given above) as well as its horizontal and vertical reflections, and would return 4. The width of the grid will be between 3 and 50 inclusive, and the height of the grid will be between 3 and 9 inclusive.  The solution will always be less than one billion (10^9).


        -- Java cases --
        Input:
        expandingNebula.Solution.solution({{true, true, false, true, false, true, false, true, true, false}, {true, true, false, false, false, false, true, true, true, false}, {true, true, false, false, false, false, false, false, false, true}, {false, true, false, false, false, false, true, true, false, false}})
        Output:
            11567

        Input:
        expandingNebula.Solution.solution({{true, false, true}, {false, true, false}, {true, false, true}})
        Output:
            4

        Input:
        expandingNebula.Solution.solution({{true, false, true, false, false, true, true, true}, {true, false, true, false, false, false, true, false}, {true, true, true, false, false, false, true, false}, {true, false, true, false, false, false, true, false}, {true, false, true, false, false, true, true, true}}
        Output:
            254

        -- Python cases --
        Input:
        solution.solution([[True, True, False, True, False, True, False, True, True, False], [True, True, False, False, False, False, True, True, True, False], [True, True, False, False, False, False, False, False, False, True], [False, True, False, False, False, False, True, True, False, False]])
        Output:
            11567

        Input:
        solution.solution([[True, False, True], [False, True, False], [True, False, True]])
        Output:
            4

        Input:
        solution.solution([[True, False, True, False, False, True, True, True], [True, False, True, False, False, False, True, False], [True, True, True, False, False, False, True, False], [True, False, True, False, False, False, True, False], [True, False, True, False, False, True, True, True]])
        Output:
            254
     */

    public static int solution(boolean[][] g) {
        g = transpose(g);
        var nCols = g[0].length;
        var nums = turnToNums(g);
        var mapping = buildMap(nCols, nums);
        Map<Integer, Integer> preimage = new TreeMap<>();
        for (int i = 0; i < Math.pow(2, nCols + 1); i++) {
            preimage.put(i, 1);
        }
        for (var row : nums) {
            Map<Integer, Integer> nextRow = new TreeMap<>();
            for (var c1 : preimage.keySet()) {
                if (mapping.containsKey(List.of(row, c1))) {
                    for (var c2 : mapping.get(List.of(row, c1))) {
                        if (nextRow.get(c2) != null) {
                            var tmp = nextRow.get(c2);
                            nextRow.put(c2, tmp + preimage.get(c1));
                        } else {
                            nextRow.put(c2, preimage.get(c1));
                        }
                    }
                }
            }
            preimage = nextRow;
        }
        return preimage.values().stream().reduce(0, Integer::sum);
    }

    private static Map<List<Integer>, Set<Integer>> buildMap(int nCols, int[] nums) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        var range = Math.pow(2, nCols + 1);
        Map<List<Integer>, Set<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                var generation = generate(i, j, nCols);
                if (numsSet.contains(generation))
                    if (mapping.containsKey(List.of(generation, i))) {
                        var value = new HashSet<>(mapping.get(List.of(generation, i)));
                        value.add(j);
                        mapping.put(List.of(generation, i), value);
                    } else {
                        mapping.put(List.of(generation, i), Set.of(j));
                    }
            }
        }
        return mapping;
    }

    private static int generate(int i, int j, int nCols) {
        var a = i & ~((int) Math.pow(2, nCols));
        var b = j & ~((int) Math.pow(2, nCols));
        var c = i >> 1;
        var d = j >> 1;
        return (a & ~b & ~c & ~d) | (~a & b & ~c & ~d) | (~a & ~b & c & ~d) | (~a & ~b & ~c & d);
    }

    private static int[] turnToNums(boolean[][] g) {
        var nums = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            var sum = 0;
            for (int j = 0; j < g[0].length; j++) {
                var elem = g[i][j];
                sum += elem ? (int) Math.pow(2, j) : 0;
            }
            nums[i] = sum;
        }
        return nums;
    }

    private static boolean[][] transpose(boolean[][] g) {
        var nRows = g.length;
        var nCols = g[0].length;
        var res = new boolean[nCols][nRows];
        var col = 0;
        for (var i : g) {
            var raw = 0;
            for (var j : i) {
                res[raw++][col] = j;
            }
            col++;
        }
        return res;
    }
}
