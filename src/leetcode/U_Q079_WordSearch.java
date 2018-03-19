package leetcode;

/**
 * Created by SunLin on 2018.3.19
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class U_Q079_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            return false;
        int rows = board.length, cols = board[0].length;
        int[][] flag = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(board, i, j, word, 0, flag))
                    return true;
            }
        }
        return false;
    }

    boolean helper(char[][] board, int i, int j, String word, int k, int[][] flag) {
        int rows = board.length, cols = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(k) || flag[i][j] == 1)
            return false;
        if (k == word.length() - 1) return true;
        flag[i][j] = 1;
        if (helper(board, i + 1, j, word, k + 1, flag)
                || helper(board, i - 1, j, word, k + 1, flag)
                || helper(board, i, j + 1, word, k + 1, flag)
                || helper(board, i, j - 1, word, k + 1, flag)) {
            return true;
        }
        flag[i][j] = 0;
        return false;
    }
}
