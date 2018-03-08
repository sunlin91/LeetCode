package SwordRefersToOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SunLin on 2018.3.8
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Q64_GetMedian {
    ArrayList<Double> list = new ArrayList<>();

    public void Insert(Integer num) {
        Double number = num.doubleValue();
        list.add(number);
    }

    public Double GetMedian() {
        int size = list.size();
        Double[] a = new Double[size];
        list.toArray(a);
        Arrays.sort(a);
        if (size % 2 == 0) {
            double res = (a[size / 2 - 1] + a[size / 2]) / 2;
            return res;
        } else {
            double res = a[size / 2];
            return res;
        }
    }
}
