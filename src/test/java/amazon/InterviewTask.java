package amazon;

import org.junit.jupiter.api.Test;

/*
        200. Number of Islands
        https://leetcode.com/problems/number-of-islands/
 */
public class InterviewTask {

    @Test
    void test() {
        System.out.println(numIslands(new char [][]{
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
}));
    }

    public int numIslands(char[][] grid) {
        var res = 0;
        var colLength = grid[0].length;
        var rowLength = grid.length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    cleanGrid(i,j,grid);
                }
            }
        }
        return res;
    }

    private void cleanGrid(int i, int j, char[][] grid) {
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            cleanGrid(i - 1, j, grid);
        if (i + 1 < grid.length && grid[i + 1][j] == '1')
            cleanGrid(i + 1, j, grid);
        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            cleanGrid(i, j - 1, grid);
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1')
            cleanGrid(i, j + 1, grid);
    }
}
