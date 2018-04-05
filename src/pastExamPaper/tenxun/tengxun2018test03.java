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
//import java.io.*;
//        import java.util.*;
//public class Main
//{
//    private static final int N=100005;
//    private static class node{
//        int x,y;
//    };
//    private static class cmp implements Comparator<node>{
//        @Override
//        public int compare(node a,node b){
//            if(a.x == b.x){
//                if(a.y==b.y) return 0;
//                return a.y<b.y?1:-1;
//            }
//            if(a.x==b.x) return 0;
//            return a.x<b.x?1:-1;
//        }
//    }
//    public static int book[]=new int[105];
//    public static node s1[]=new node[N];
//    public static node s2[]=new node[N];
//    public static void main(String[] args){
//        for(int i=0;i<N;i++){
//            s1[i]=new node();
//            s2[i]=new node();
//        }
//        int n,m,i,j,cnt;
//        long sum;
//        Scanner sc=new Scanner(new InputStreamReader(System.in));
//        while(sc.hasNext()){
//            n=sc.nextInt();
//            m=sc.nextInt();
//            for(i = 0; i<n; i++){
//                s1[i].x=sc.nextInt();
//                s1[i].y=sc.nextInt();
//            }
//            for(i = 0; i<m; i++){
//                s2[i].x=sc.nextInt();
//                s2[i].y=sc.nextInt();
//            }
//            Arrays.sort(s1,0,n,new cmp());
//            Arrays.sort(s2,0,m,new cmp());
//            sum=cnt=0;
//            Arrays.fill(book,0);
//            for(i=0,j=0;i<m;i++){
//                while(j<n&&s1[j].x>=s2[i].x){
//                    book[s1[j].y]++;
//                    j++;
//                }
//                for(int k=s2[i].y;k<=100;k++){
//                    if(book[k]>0){
//                        book[k]--;
//                        sum+=(s2[i].x*200+s2[i].y*3);
//                        cnt++;
//                        break;
//                    }
//                }
//            }
//            System.out.println(cnt+" "+sum);
//        }
//        sc.close();
//    }
//}

