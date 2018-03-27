package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 */
public class wangyi2018test03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] D = new int[N];
        int[] P = new int[N];
        int[] A = new int[M];
        int[] res = new int[M];
        for (int i=0;i<N;i++){
            D[i]=sc.nextInt();
            P[i]=sc.nextInt();
        }
        shellSort(D,P);
        for (int i=0;i<M;i++){
            A[i]=sc.nextInt();
        }
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                if (D[j]>A[i])
                    break;
                if (P[j]>res[i])
                    res[i]=P[j];
            }
        }
        for (int i=0;i<M;i++){
            System.out.println(res[i]);
        }
    }

    public static void shellSort(int[] a,int[] b){
        int i,j,k,k2;
        for(int dk=a.length/2;dk>=1;dk=dk/2)
            for(i=dk;i<a.length;i++){
                if(a[i]<a[i-dk]){
                    k=a[i];
                    k2=b[i];
                    for(j=i-dk;j>=0&&k<a[j];j-=dk){
                        a[j+dk]=a[j];
                        b[j+dk]=b[j];
                    }
                    a[j+dk]=k;
                    b[j+dk]=k2;
                }
            }
    }
}
