package leetCode;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        var res = checkHorizontal(board);
        if (!res) {
            return false;
        }
        res = checkVertical(board);
        if (!res) {
            return false;
        }
        res = checkSquare(board);
        return res;
    }

    private static boolean checkHorizontal(char[][] board) {
        for (var ch : board) {
            int[] set = new int[9];
            for (var num : ch) {
                if (num == '.') {
                    continue;
                }
                var numericValue = Character.getNumericValue(num);
                if (set[numericValue - 1] != 0) {
                    return false;
                }
                set[numericValue - 1] = numericValue;
            }
        }
        return true;
    }

    private static boolean checkVertical(char[][] board) {
        for (byte i = 0; i < 9; i++) {
            int[] set = new int[9];
            for (var num : board) {
                if (num[i] == '.') {
                    continue;
                }
                var numericValue = Character.getNumericValue(num[i]);
                if (set[numericValue - 1] != 0) {
                    return false;
                }
                set[numericValue - 1] = numericValue;
            }
        }
        return true;
    }

    private static boolean checkSquare(char[][] board) {
        byte iLimit = 2;
        byte jLimit = 2;
        byte count = 0;
        int[] set = new int[9];
        for (byte i = 0, j = 0; i < 9 && j < 9; i++) {
            if (board[j][i] != '.') {
                var numericValue = Character.getNumericValue(board[j][i]);
                if (set[numericValue - 1] != 0) {
                    return false;
                }
                set[numericValue - 1] = numericValue;
            }

            if (i == iLimit && j < jLimit) {
                j++;
                i -= 3;
            }
            if (i == iLimit && j == jLimit) {
                set = new int[9];
                count++;
                if (count % 3 == 0) {
                    i -= 9;
                    j++;
                    iLimit = 2;
                    jLimit += 3;
                } else {
                    j -= 2;
                    iLimit += 3;
                }
            }
        }
        return true;
    }
}
