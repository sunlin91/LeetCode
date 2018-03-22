package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Q09_4_RectangularOverlay {
    //和青蛙跳格子类似，横向上一次覆盖1格还是2格的问题
    public int RectCover(int target) {
        if (target==0)
            return 0;
        int g = 2;
        int f = 1;
        while (target-->1){
            g+=f;
            f=g-f;
        }
        return f;
    }
}

