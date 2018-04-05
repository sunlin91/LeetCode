package pastExamPaper.tenxun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by SUN on 2018/4/5
 */
public class tengxun2018test03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] X = new int[n];
        int[] Y = new int[n];
        int[] flag = new int[n];
        Arrays.fill(flag,0);//0表示没使用
        int[] Z = new int[m];
        int[] W = new int[m];
        for (int i=0;i<n;i++){
            X[i]=sc.nextInt();
            Y[i]=sc.nextInt();
        }
        for (int i=0;i<m;i++){
            Z[i]=sc.nextInt();
            W[i]=sc.nextInt();
        }
        sort(X,Y);sort(Z,W);
        int res1 =0,res2=0;

        for (int i=m-1;i>=0;i--){
            for (int j=0;j<n;j++){
                if (flag[j]==0&&X[j]>=Z[i]&&Y[j]>=W[i]){
                    res1+=1;
                    res2+=200*Z[i]+3*W[i];
                    flag[j]=1;
                }
            }
        }
        System.out.println(res1+" "+res2);
    }

    public static void sort(int[] a,int[] b){
        int h=1,temp,temp2;
        while(h<a.length/3)
            h=3*h+1;
        while(h>=1){
            for(int i=h;i<a.length;i++){
                for(int j=i;j>=h&&a[j]<a[j-h];j-=h){
                    temp=a[j];
                    a[j]=a[j-h];
                    a[j-h]=temp;

                    temp2=b[j];
                    b[j]=b[j-h];
                    b[j-h]=temp2;
                }
            }
            h=h/3;
        }
    }
}
