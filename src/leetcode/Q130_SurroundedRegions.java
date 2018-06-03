package leetcode;

/**
 * Created by SUN on 2018/6/3
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O),
 * capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on
 * the border will be flipped to 'X'. Two cells are connected
 * if they are adjacent cells connected horizontally or vertically.
 */
public class Q130_SurroundedRegions {
    public static void main(String[] args){
        char[][] a = new char[][]{{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},
                {'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        solve(a);
    }
    public static void solve(char[][] board) {
        if (board==null||board.length==0)
            return;
        int row = board.length;
        int col = board[0].length;
        for (int i=0;i<row;i++){
            if (board[i][0]=='O'){
                helper(i,0,board);
            }
            if (board[i][col-1]=='O'){
                helper(i,col-1,board);
            }
        }
        for (int j=0;j<col;j++){
            if (board[0][j]=='O'){
                helper(0,j,board);
            }
            if (board[row-1][j]=='O'){
                helper(row-1,j,board);
            }
        }
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '1') board[i][j] = 'O';

    }

    static void helper(int i,int j,char[][] board){
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i > 1) helper(i - 1, j,board);
            if (j > 1) helper(i, j - 1,board);
            if (i + 1 < board.length) helper(i + 1, j,board);
            if (j + 1 < board[0].length) helper(i, j + 1,board);
        }
    }
}
