package pastExamPaper.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by SUN on 2018.3.1.
 * <p>
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，
 * 他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * <p>
 * <p>
 * 输出描述:
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * <p>
 * 输入例子1:
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * <p>
 * 输出例子1:
 * 5
 * 6
 * 5
 * 9
 */
public class test07 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] score = new int[N];
            for(int i=0;i<N;i++){
                score[i]=sc.nextInt();
            }
            for(int i=0;i<M;i++){
                String str = sc.next();
                int A = sc.nextInt();
                int B = sc.nextInt();
                if(str.equals("Q"))
                    list.add(query(score,A-1,B-1));
                if(str.equals("U"))
                    update(score,A-1,B);
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static int query(int[] score,int a,int b){
        if(a>b){
            int tmp = a;
            a=b;
            b=tmp;
        }
        int maxScore = score[a];
        for(int i=a+1;i<=b;i++){
            if (maxScore<score[i])
                maxScore=score[i];
        }
        return maxScore;
    }

    public static void update(int[] score,int a,int b){
        score[a]=b;
    }
}
