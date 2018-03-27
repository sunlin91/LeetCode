package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 * 跳石板
 * 石板编号1、2、3、。。。
 * 在K编号上只能往前跳K的约束步（不含1和K本身）。
 * 问在N上想跳到M上，最少跳多少步。（4<=N<=M<=100000)
 */
public class wangyi2017test05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //dst表示到达i位置的步数，-1表示不可达
        int[] dst = new int[M+1];
        for (int i=N;i<=M;i++){
            dst[i]=-1;//初始化
        }
        dst[N]=0;//从N开始，dst[N]为0步
        for (int i=N;i<=M;i++){
            if (dst[i]==-1)//如果该位置不可达则直接跳过
                continue;
            for (int j=2;j*2<=i;j++){
                if (i%j==0){//寻找约束，也就是跳的步数
                    if (i+j<=M&&dst[i+j]==-1)//如果跳的位置<=M并且该位置未到过
                        dst[i+j]=dst[i]+1;//步数在调过来的基础上+1
                }
            }
        }
        System.out.println(dst[M]);
    }
}
