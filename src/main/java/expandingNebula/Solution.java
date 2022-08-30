package expandingNebula;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Solution {
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
