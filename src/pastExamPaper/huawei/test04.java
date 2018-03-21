package pastExamPaper.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by SUN on 2018.3.1.
 * <p>
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
 * 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 * <p>
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 * <p>
 * <p>
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 * <p>
 * 输入例子1:
 * 8
 * <p>
 * 输出例子1:
 * 6
 */
public class test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            boolean[] a = new boolean[n];
            int sign = n, flag = 0;
            while (sign != 0) {
                for (int i = 0; i < n; i++) {
                    if (a[i] == false) {
                        flag++;
                        if (flag == 3) {
                            flag = 0;
                            a[i] = true;
                            sign--;
                            if (sign == 0) {
                                list.add(i);
                                break;
                            }
                        }
                    }
                }
                if (sign == 0)
                    break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
