package pastExamPaper.ali;
/**
 * Created by SUN on 2018/7/19
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ali2018test01 {

/**
 *  输入如
 *  3
 *  1,2
 *  3,2
 *  4,5
 *  计算从0,0出发，到各个配送站的最短路径包括返回0,0的最短路径
 *  请完成下面这个函数，实现题目要求的功能
 *  当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    //80%
    static int calculate(String[] locations) {
        int result = 0;
        int[] mark = new int[locations.length];
        Arrays.fill(mark,0);
        String pos = "0,0";
        String last ="";
        for (int j=0;j<locations.length;j++){
            if (mark[j]==1)
                continue;
            int marker = j;
            int distance = Integer.MAX_VALUE;
            for(int i=0;i<locations.length;i++){
                if(pos.equals(locations[i])||mark[i]==1)
                    continue;
                int d = helper(pos,locations[i]);
                if (d<distance){
                    pos = locations[i];
                    distance = d;
                    marker = i;
                }
            }
            mark[marker]=1;
            result+=distance;
        }
        last = pos;
        return result+helper("0,0",last);
    }

    static int helper(String a,String b){
        int ax = Integer.valueOf(a.split(",")[0]);
        int ay = Integer.valueOf(a.split(",")[1]);
        int bx = Integer.valueOf(b.split(",")[0]);
        int by = Integer.valueOf(b.split(",")[1]);
        return Math.abs(ax-bx)+Math.abs(ay-by);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }

        System.out.println(calculate(locations));
    }
}