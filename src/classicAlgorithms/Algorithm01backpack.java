package classicAlgorithms;

/**
 * Created by SunLin on 2018.3.27
 */
public class Algorithm01backpack {
    public static void main(String[] args) {
        int bagVolume = 10;
        int[][] T = new int[7][bagVolume + 1];//表示第i个物品放入容量j的最大值，背包容量20
        int[] p = new int[]{0, 2, 5, 3, 10, 4, 9};//第i个物品的价值
        int[] w = new int[]{0, 1, 3, 2, 6, 2, 5};//第i个物品的体积
        for (int i = 1;i<p.length;i++){
            for (int j=1;j<=bagVolume;j++){
                if (j<w[i]){//如果当前背包容量大小放不下第i个物品
                    T[i][j]=T[i-1][j];
                }else {
                    T[i][j]=Math.max(T[i - 1][j], T[i - 1][j - w[i]] + p[i]);
                }
            }
        }
        System.out.println("最大价值为："+T[6][bagVolume]);

        //输出查看T表
        for (int i=0;i<T.length;i++){
            for (int j=0;j<T[0].length;j++){
                System.out.format("%4d",T[i][j]);
            }
            System.out.println();
        }
    }
}
