package pastExamPaper.huawei;

import java.util.Scanner;

/**
 * Created by SUN on 2018.3.1.
 * 数独
 */
public class test06 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        int i=0;
        while (sc.hasNextLine()&&i<9){
            String str = sc.nextLine();
            for(int j=0;j<9;j++){
                board[i][j]=str.split(" ")[j].charAt(0);
            }
            i++;
        }
        solve(board);
        for(int a=0;a<9;a++){
            for(int b=0;b<9;b++){
                if (b==8){
                    System.out.print(board[a][b]+"\n");
                }else {
                    System.out.print(board[a][b]+" ");
                }
            }
        }
    }

    public static boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '0'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '0'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '0' && board[i][col] == c) return false; //check row
            if(board[row][i] != '0' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '0' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
