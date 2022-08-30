package amazon;

public class InterviewTask {

    /**
     * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water)
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * @param grid is a matrix with 0 and 1;
     * @return the number of islands.
     */

    public static int numIslands(char[][] grid) {
        var res = 0;
        var colLength = grid[0].length;
        var rowLength = grid.length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    cleanGrid(i, j, grid);
                }
            }
        }
        return res;
    }

    private static void cleanGrid(int i, int j, char[][] grid) {
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
