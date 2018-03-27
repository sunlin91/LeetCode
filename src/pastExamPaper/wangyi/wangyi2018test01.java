package pastExamPaper.wangyi;

import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.27
 */
public class wangyi2018test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        int minx1 = Integer.MAX_VALUE;
        int miny1 = Integer.MAX_VALUE;
        int maxx2 = Integer.MIN_VALUE;
        int maxy2 = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            x1[i]=sc.nextInt();
            if (x1[i]<minx1)
                minx1=x1[i];
        }
        for (int i=0;i<n;i++){
            y1[i]=sc.nextInt();
            if (y1[i]<miny1)
                miny1=y1[i];
        }
        for (int i=0;i<n;i++){
            x2[i]=sc.nextInt();
            if (x2[i]>maxx2)
                maxx2=x2[i];
        }
        for (int i=0;i<n;i++){
            y2[i]=sc.nextInt();
            if (y2[i]>maxy2)
                maxy2=y2[i];
        }
        int res = 0;
//        for (int xx=minx1;xx<=maxx2;xx++){
//            for (int yy=miny1;yy<=maxy2;yy++){
//                int cur = 0;
//                for (int i=0;i<n;i++){
//                    if (helper(xx,yy,x1,y1,x2,y2,i)) {
//                        cur++;
//                    }
//                }
//                if (res<cur)
//                    res=cur;
//            }
//        }
        for (int i=0;i<n;i++){
            for (int xx=x1[i]+1;xx<x2[i];xx++){
                for (int yy=y1[i]+1;yy<y2[i];yy++){
                    int cur = 0;
                    for (int ii=0;ii<n;ii++){
                    if (helper(xx,yy,x1,y1,x2,y2,ii)) {
                        cur++;
                    }
                }
                if (res<cur)
                    res=cur;
                }
            }
        }
        if (res==0)
            res=1;
        System.out.println(res);
    }

    static boolean helper(int x,int y,int[] x1,int[] y1,int[] x2,int[] y2,int i){
        return x1[i]<x&&y1[i]<y&&x2[i]>x&&y2[i]>y;
    }
}
