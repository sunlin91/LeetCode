package pastExamPaper.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 80%
 */
public class huawei2018test03 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int flow_rate = Integer.parseInt(sc.nextLine().trim());
        if (flow_rate<=0){
            System.out.println();
            return;
        }

        sc.nextLine();
        String str2[] = sc.nextLine().trim().split(" ");

        int array[] = new int[str2.length], array2[] = new int[str2.length];
        for (int i = 0; i < str2.length; i++) {
            array[i] = Integer.parseInt(str2[i]);
            array2[i] = array[i];
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Arrays.sort(array);
        int i = 0, j = 0, tempSum = 0, minSum = Integer.MIN_VALUE;
        while (i <= j && j < array.length) {
            while (j < array.length && tempSum <= flow_rate) {
                list.add(array[j]);
                tempSum += array[j++];
                if (tempSum <= flow_rate)
                    minSum = Math.max(minSum, tempSum);
                if (minSum <= tempSum && tempSum < flow_rate) {
                    list1.clear();
                    list1.addAll(list);
                }
            }
            while (i < j && tempSum > flow_rate) {
                list.remove(list.lastIndexOf(array[i]));
                tempSum -= array[i++];
                if (tempSum <= flow_rate)
                    minSum = Math.max(minSum, tempSum);
                if (minSum <= tempSum && tempSum <= flow_rate) {
                    list1.clear();
                    list1.addAll(list);
                }

            }

        }
        StringBuilder res = new StringBuilder("");
        for (int k = 0; k < array2.length; k++) {
            if (list1.contains(array2[k])) {
                list1.remove(list1.lastIndexOf(array2[k]));
                res.append(k + 1 + " ");
            }
        }
        System.out.println(res.substring(0,res.length()-1));
    }
}
