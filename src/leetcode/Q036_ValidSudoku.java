package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2018.1.4.
 */
public class Q036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)
            return false;
        List[] row = new List[9];
        List[] column = new List[9];
        List[] grid = new List[9];
        init(row);
        init(column);
        init(grid);
        boolean result=isValid(row,column,grid,board);

        return result;
    }

    public boolean isValid(List[] row,List[] column,List[] grid,char[][] board){
        int m=0,n=0,gridn=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                m=3*i;n=3*j;gridn=i*3+j;
//                System.out.println(gridn);
                for(int mi=m;mi<m+3;mi++){
                    for(int nj=n;nj<n+3;nj++){
//                        System.out.print("["+mi+","+nj+"]");
                        if(board[mi][nj]!='.'){
                            if(!row[mi].remove((Character)board[mi][nj])){
                                return false;
                            }
                            if(!column[nj].remove((Character)board[mi][nj])){
                                return false;
                            }
                            if(!grid[gridn].remove((Character)board[mi][nj])){
                                return false;
                            }
//                            if(row[mi].isEmpty()
//                                    ||column[nj].isEmpty()
//                                    ||grid[gridn].isEmpty())
//                                return false;
                        }
                    }
//                    System.out.println();
                }
            }
        }
        return true;
    }

    public void init(List[] lists){
        for(int i=0;i<lists.length;i++){
            lists[i]=new ArrayList<Integer>();
            lists[i].add('1');
            lists[i].add('2');
            lists[i].add('3');
            lists[i].add('4');
            lists[i].add('5');
            lists[i].add('6');
            lists[i].add('7');
            lists[i].add('8');
            lists[i].add('9');
        }
    }
}
